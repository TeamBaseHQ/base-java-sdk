package com.base.Http.Clients;

import com.base.Exceptions.BaseHttpException;
import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class OkHttpClient implements HttpClientInterface {

    /**
     * Implementation of {@link HttpClientInterface}
     *
     * @param request  {@link Request}
     * @param response {@link Response}
     * @return Response
     * @throws BaseHttpException
     */
    @Override
    public Response send(Request request, Response response) throws BaseHttpException {

        // Send the Request and Fetch the Response
        try {
            // Request Builder
            okhttp3.Request.Builder requestBuilder = new okhttp3.Request.Builder()
                    .url(request.getUrl());

            // Prepare the headers
            this.prepareHeaders(request, requestBuilder);

            // Request Body
            RequestBody requestBody = null;

            // The Request has Body
            if (this.requestHasBody(request)) {
                // Prepare the Body
                requestBody = this.buildRequestBody(request);
            }

            // Add body to the request
            requestBuilder.method(request.getMethod(), requestBody);

            // Build the Request
            okhttp3.Request okHttpRequest = requestBuilder.build();


            // Create the Client
            okhttp3.OkHttpClient client = new okhttp3.OkHttpClient();
            okhttp3.Response okHttpResponse = client.newCall(okHttpRequest).execute();

            String body = okHttpResponse.body().string();
            Map<String, String> responseHeaders = this.getResponseHeaders(okHttpResponse);

            if (response == null) {
                response = new Response(request);
            }

            response.setBody(body)
                    .setHeaders(responseHeaders)
                    .setStatusCode(okHttpResponse.code());

            return response;
        } catch (Exception e) {
            throw new BaseHttpException(500, e.getMessage(), response);
        }
    }

    /**
     * This method accepts the {@link Request} if the request's method is patch, post or put then it will true or else false.
     *
     * @param request {@link Request}
     * @return true or false on the basis of which type of request come.
     */
    private boolean requestHasBody(Request request) {
        return request.getMethod().equalsIgnoreCase(Request.METHOD_PATCH) ||
                request.getMethod().equalsIgnoreCase(Request.METHOD_POST) ||
                request.getMethod().equalsIgnoreCase(Request.METHOD_PUT);
    }

    /**
     * It will Return the {@link com.base.Http.Request.RequestBody} on the basis of {@link Request}
     *
     * @param request {@link Request}
     * @return ResponseBody {@link ResponseBody}
     * @throws Exception
     */
    private RequestBody buildRequestBody(Request request) throws Exception {
        // Request is multipart
        if (this.requestIsMultipart(request)) {
            // Build Request Body
            MultipartBody.Builder bodyBuilder = this.getMultiPartBuilder();
            this.addParamsToBuilder(bodyBuilder, request.getParameters());
            this.addFilesToBuilder(bodyBuilder, request.getFiles());
            return bodyBuilder.build();
        }

        // Simple Request
        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        this.addParamsToBuilder(formBodyBuilder, request.getParameters());
        return formBodyBuilder.build();
    }

    /**
     * Accept the {@link Request} and return true if {@link Request} is Multipart or else not.
     *
     * @param request {@link Request}
     * @return java.lang.Boolean
     */
    private boolean requestIsMultipart(Request request) {
        return (request.getMethod().equalsIgnoreCase(Request.METHOD_POST)) &&
                (!request.getParameters().isEmpty() || !request.getFiles().isEmpty());
    }

    /**
     * Get Response Headers.
     *
     * @param okHttpResponse
     * @return
     */
    private Map<String, String> getResponseHeaders(okhttp3.Response okHttpResponse) {
        Map<String, String> headers = new HashMap<>();
        Headers okHttpHeaders = okHttpResponse.headers();
        Iterator<String> iterator = okHttpHeaders.names().iterator();

        while (iterator.hasNext()) {
            String key = iterator.next();
            String value = headers.get(key);

            headers.put(key, value);
        }

        return headers;
    }

    /**
     * Prepare Request Headers.
     *
     * @param request
     * @param requestBuilder
     */
    private void prepareHeaders(Request request, okhttp3.Request.Builder requestBuilder) {
        Map<String, String> headers = request.getHeaders();

        for (String headerKey : headers.keySet()) {
            String headerValue = headers.get(headerKey);
            requestBuilder.addHeader(headerKey, headerValue);
        }
    }

    /**
     * Get {@link MultipartBody.Builder}
     *
     * @return MultipartBody.Builder
     * @throws Exception
     */
    private MultipartBody.Builder getMultiPartBuilder() throws Exception {
        return new MultipartBody.Builder()
                .setType(MultipartBody.FORM);
    }

    /**
     * It wll add parameters to the Builder
     *
     * @param builder
     * @param parameters Map of
     */
    private void addParamsToBuilder(FormBody.Builder builder, Map<String, String> parameters) {
        for (String key : parameters.keySet()) {
            String value = parameters.get(key);
            // If key is `user_ids*1`, its part of a value (user_ids[]) array. Else, it's a single value.
            String keyName = key.contains("*") ? key.substring(0, key.indexOf('*')).concat("[]") : key;

            builder.add(keyName, value);
        }
    }


    private void addParamsToBuilder(MultipartBody.Builder builder, Map<String, String> parameters) {
        for (String key : parameters.keySet()) {
            String value = parameters.get(key);
            // If key is `user_ids*1`, its part of a value (user_ids[]) array. Else, it's a single value.
            String keyName = key.contains("*") ? key.substring(0, key.indexOf('*')).concat("[]") : key;

            builder.addFormDataPart(keyName, value);
        }
    }

    private void addFilesToBuilder(MultipartBody.Builder builder, Map<String, File> files) throws Exception {
        for (String key : files.keySet()) {
            File file = files.get(key);

            // If key is `allFiles*1`, its part of a file (allFiles[]) array. Else, it's a single file.
            String fileName = key.contains("*") ? key.substring(0, key.indexOf('*')).concat("[]") : key;

            if (file.exists()) {
                MediaType fileType = MediaType.parse("application/octet-stream");
                builder.addFormDataPart(fileName, file.getName(), RequestBody.create(fileType, file));
            }
        }
    }
}
