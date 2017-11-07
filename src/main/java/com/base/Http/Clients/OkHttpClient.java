package com.base.Http.Clients;

import com.base.Exceptions.BaseHttpException;
import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import okhttp3.Headers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class OkHttpClient implements HttpClientInterface {

    /**
     * Send Request.
     *
     * @param request
     * @return Response
     * @throws BaseHttpException
     */
    public Response send(Request request) throws BaseHttpException {
        okhttp3.Request.Builder requestBuilder = new okhttp3.Request.Builder()
                .url(request.getUrl());

        // Prepare Headers
        this.prepareHeaders(request, requestBuilder);

        // Build the Request
        okhttp3.Request okHttpRequest = requestBuilder.build();

        // Create the Client
        okhttp3.OkHttpClient client = new okhttp3.OkHttpClient();

        // Send the Request and Fetch the Response
        try {
            okhttp3.Response okHttpResponse = client.newCall(okHttpRequest).execute();

            String body = okHttpResponse.body().string();
            Map<String, String> responseHeaders = this.getResponseHeaders(okHttpResponse);
            return new Response(request, responseHeaders, okHttpResponse.code(), body);
        } catch (Exception e) {
            throw new BaseHttpException(500, e.getMessage());
        }
    }

    /**
     * Get Response Headers.
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
}
