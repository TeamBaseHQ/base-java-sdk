package com.base;

import com.base.Auth.AccessToken;
import com.base.Exceptions.BaseHttpException;
import com.base.Http.Clients.HttpClientInterface;
import com.base.Http.Clients.OkHttpClient;
import com.base.Http.Request.Request;
import com.base.Http.Response.Handlers.BaseResponseHandler;
import com.base.Http.Response.Handlers.HandlerInterface;
import com.base.Http.Response.Response;

import java.util.HashMap;
import java.util.Map;

public final class BaseClient {

    private static final String DEFAULT_API_URL = "https://backend.baseapp.io/api";

    private String apiUrl;

    private String clientId;

    private String clientSecret;

    private AccessToken accessToken;

    private Map<String, String> headers;

    private HttpClientInterface httpClient;

    private HandlerInterface responseHandler;

    public BaseClient() {
        this.httpClient = new OkHttpClient();
        this.headers = BaseClient.getDefaultHeaders();
        this.apiUrl = BaseClient.DEFAULT_API_URL;
    }

    public BaseClient(HttpClientInterface httpClient) {
        this();
        this.httpClient = httpClient;
        this.responseHandler = new BaseResponseHandler();
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
        return headers;
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
        return accessToken;
    }

    public BaseClient setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public Response sendRequest(String endpoint, String method) throws BaseHttpException {
        String url = this.buildUrl(endpoint);
        Request request = makeRequest(url, method);

        Response response = this.httpClient.send(request);

        return this.responseHandler.handle(response);
    }

    private String buildUrl(String endpoint) {
        return this.getApiUrl().concat(endpoint);
    }

    private Request makeRequest(String url, String method) {
        Request request = new Request(url, method);
        request.setHeaders(this.headers);
        return request;
    }

    private static Map<String, String> getDefaultHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        return headers;
    }

    private Map<String, String> buildHeaders() {
        // Get All the Headers
        Map<String, String> headers = this.getHeaders();

        // Add the Auth Headers
        headers.putAll(this.getAuthHeaders());

        return headers;
    }

    private Map<String, String> getAuthHeaders() {
        Map<String, String> headers = new HashMap<>();

        if (this.getAccessToken().getAccessToken() != null) {
            headers.put("Authorization", "Bearer ".concat(this.getAccessToken().getAccessToken()));
        }

        if (this.getClientId() != null) {
            headers.put("CLIENT_ID", this.getClientId());
        }

        if (this.getClientSecret() != null) {
            headers.put("CLIENT_ID", this.getClientSecret());
        }


        return headers;
    }
}
