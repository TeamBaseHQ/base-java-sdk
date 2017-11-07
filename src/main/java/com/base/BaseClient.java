package com.base;

import com.base.Auth.AccessToken;
import com.base.Exceptions.BaseHttpException;
import com.base.Http.Clients.HttpClientInterface;
import com.base.Http.Clients.OkHttpClient;
import com.base.Http.Request.Request;
import com.base.Http.Request.RequestBody;
import com.base.Http.Response.Handlers.BaseResponseHandler;
import com.base.Http.Response.Handlers.HandlerInterface;
import com.base.Http.Response.Response;

import java.util.HashMap;
import java.util.Map;

public final class BaseClient {

    private static final String DEFAULT_API_URL = "http://baseapp-backend.kunalvarma.in/api";

    private String apiUrl;

    private String clientId;

    private String clientSecret;

    private AccessToken accessToken;

    private Map<String, String> headers;

    private HttpClientInterface httpClient;

    private HandlerInterface responseHandler;

    public BaseClient() {
        this.httpClient = new OkHttpClient();
        this.apiUrl = BaseClient.DEFAULT_API_URL;
        this.headers = BaseClient.getDefaultHeaders();
        this.responseHandler = new BaseResponseHandler();
    }

    public BaseClient(HttpClientInterface httpClient) {
        this();
        this.httpClient = httpClient;
    }

    public BaseClient(HttpClientInterface httpClient, HandlerInterface responseHandler) {
        this();
        this.httpClient = httpClient;
        this.responseHandler = responseHandler;
    }

    public BaseClient(HttpClientInterface httpClient, HandlerInterface responseHandler, Map<String, String> headers) {
        this(httpClient, responseHandler);
        this.headers = headers;
    }


    public HttpClientInterface getHttpClient() {
        return httpClient;
    }

    public BaseClient setHttpClient(HttpClientInterface httpClient) {
        this.httpClient = httpClient;
        return this;
    }

    public HandlerInterface getResponseHandler() {
        return responseHandler;
    }

    public BaseClient setResponseHandler(HandlerInterface responseHandler) {
        this.responseHandler = responseHandler;
        return this;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public BaseClient addHeader(String key, String value) {
        this.headers.put(key, value);
        return this;
    }

    public BaseClient setHeaders(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    public String getApiUrl() {
        if (this.apiUrl != null) {
            return apiUrl;
        }

        return BaseClient.DEFAULT_API_URL;
    }

    public BaseClient setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
        return this;
    }

    public String getClientId() {
        return clientId;
    }

    public BaseClient setClientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public BaseClient setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
        return this;
    }

    public AccessToken getAccessToken() {
        return this.accessToken;
    }

    public BaseClient setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public Response sendRequest(Request request, Response response) throws BaseHttpException {
        request.setUrl(this.buildUrl(request.getEndpoint()));
        request.setHeaders(this.buildHeaders(request));

        return this.getHttpClient().send(request, response);
    }

    private String buildUrl(String endpoint) {
        return this.getApiUrl().concat(endpoint);
    }

    private static Map<String, String> getDefaultHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        return headers;
    }

    private Map<String, String> buildHeaders(Request request) {
        // Get All the Headers
        Map<String, String> allHeaders = BaseClient.getDefaultHeaders();

        // Add the Auth Headers
        allHeaders.putAll(this.getAuthHeaders(request));
        // Add the Custom Headers
        allHeaders.putAll(request.getHeaders());

        return allHeaders;
    }

    private Map<String, String> getAuthHeaders(Request request) {
        Map<String, String> headers = new HashMap<>();
        AccessToken accessToken = this.getAccessToken();

        if (request.getAccessToken() != null) {
            accessToken = request.getAccessToken();
        }

        if (accessToken !=  null) {
            headers.put("Authorization", "Bearer ".concat(accessToken.getAccessToken()));
        }

        if (this.getClientId() != null) {
            headers.put("X-CLIENT-ID", this.getClientId());
        }

        if (this.getClientSecret() != null) {
            headers.put("X-CLIENT-SECRET", this.getClientSecret());
        }


        return headers;
    }
}
