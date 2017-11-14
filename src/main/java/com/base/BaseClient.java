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

    /**
     * BaseClient Default API URL
     */
    private static final String DEFAULT_API_URL = "http://baseapp-backend.kunalvarma.in/api";

    /**
     * Base Client apiUrl
     */
    private String apiUrl;

    /**
     * Base Client clientId
     */
    private String clientId;

    /**
     * Base Client clientSecret
     */
    private String clientSecret;

    /**
     * Base Client {@link AccessToken}
     */
    private AccessToken accessToken;

    /**
     * Base Client headers
     */
    private Map<String, String> headers;

    /**
     * Base Client {@link HttpClientInterface}
     */
    private HttpClientInterface httpClient;

    /**
     * Base Client {@link HandlerInterface}
     */
    private HandlerInterface responseHandler;

    /**
     * Generate {@link BaseClient} Object
     */
    public BaseClient() {
        this.httpClient = new OkHttpClient();
        this.apiUrl = BaseClient.DEFAULT_API_URL;
        this.headers = BaseClient.getDefaultHeaders();
        this.responseHandler = new BaseResponseHandler();
    }

    /**
     * Generate {@link BaseClient} with {@link HttpClientInterface}
     *
     * @param httpClient
     */
    public BaseClient(HttpClientInterface httpClient) {
        this();
        this.httpClient = httpClient;
    }

    /**
     * Generate {@link BaseClient} with {@link HttpClientInterface} and {@link HandlerInterface}
     *
     * @param httpClient
     * @param responseHandler
     */
    public BaseClient(HttpClientInterface httpClient, HandlerInterface responseHandler) {
        this();
        this.httpClient = httpClient;
        this.responseHandler = responseHandler;
    }

    /**
     * Generate {@link BaseClient} with {@link HttpClientInterface} and {@link HandlerInterface} and Headers
     *
     * @param httpClient
     * @param responseHandler
     * @param headers
     */
    public BaseClient(HttpClientInterface httpClient, HandlerInterface responseHandler, Map<String, String> headers) {
        this(httpClient, responseHandler);
        this.headers = headers;
    }

    /**
     * Set Default Headers for {@link Request}
     *
     * @return
     */
    private static Map<String, String> getDefaultHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        return headers;
    }

    /**
     * Return {@link HttpClientInterface}
     *
     * @return HttpClientInterface
     */
    public HttpClientInterface getHttpClient() {
        return httpClient;
    }


    /**
     * Set Base Client HttpClient
     *
     * @param httpClient
     * @return
     */
    public BaseClient setHttpClient(HttpClientInterface httpClient) {
        this.httpClient = httpClient;
        return this;
    }

    /**
     * Return Base Client ResponseHandler
     *
     * @return
     */
    public HandlerInterface getResponseHandler() {
        return responseHandler;
    }

    /**
     * Set Base Client ResponseHandler
     *
     * @param responseHandler
     * @return
     */
    public BaseClient setResponseHandler(HandlerInterface responseHandler) {
        this.responseHandler = responseHandler;
        return this;
    }

    /**
     * Return Base Client Headers
     *
     * @return
     */
    public Map<String, String> getHeaders() {
        return this.headers;
    }

    /**
     * Set Base Client Headers
     *
     * @param headers
     * @return
     */
    public BaseClient setHeaders(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    /**
     * Add {@link BaseClient} Headers
     *
     * @param key
     * @param value
     * @return
     */
    public BaseClient addHeader(String key, String value) {
        this.headers.put(key, value);
        return this;
    }

    /**
     * Return Base Client ApiUrl
     *
     * @return
     */
    public String getApiUrl() {
        if (this.apiUrl != null) {
            return apiUrl;
        }
        return BaseClient.DEFAULT_API_URL;
    }

    /**
     * Set Base Client ApiUrl
     *
     * @param apiUrl
     * @return
     */
    public BaseClient setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
        return this;
    }

    /**
     * Return Base Client ClientId
     *
     * @return
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * Set Base Client ClientId
     *
     * @param clientId
     * @return
     */
    public BaseClient setClientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    /**
     * Return Base Client ClientSecret
     *
     * @return
     */
    public String getClientSecret() {
        return clientSecret;
    }

    /**
     * Set Base Client ClientSecret
     *
     * @param clientSecret
     * @return
     */
    public BaseClient setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
        return this;
    }

    /**
     * Return Base Client AccessToken
     *
     * @return
     */
    public AccessToken getAccessToken() {
        return this.accessToken;
    }

    /**
     * Set Base Client AccessToken
     *
     * @param accessToken
     * @return
     */
    public BaseClient setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    /**
     * Send Request with {@link Request} and {@link Response}
     *
     * @param request
     * @param response
     * @return Response
     * @throws BaseHttpException Exception
     */
    public Response sendRequest(Request request, Response response) throws BaseHttpException {
        request.setUrl(this.buildUrl(request.getEndpoint()));
        request.setHeaders(this.buildHeaders(request));

        return this.getResponseHandler().handle(this.getHttpClient().send(request, response));
    }

    /**
     * Return BaseClient URL with endPoint and Default URL
     *
     * @param endpoint
     * @return URL
     */
    private String buildUrl(String endpoint) {
        return this.getApiUrl().concat(endpoint);
    }

    /**
     * Generate {@link Request} Headers
     *
     * @param request
     * @return
     */
    private Map<String, String> buildHeaders(Request request) {
        // Get All the Headers
        Map<String, String> allHeaders = BaseClient.getDefaultHeaders();

        // Add the Auth Headers
        allHeaders.putAll(this.getAuthHeaders(request));
        // Add the Custom Headers
        allHeaders.putAll(request.getHeaders());

        return allHeaders;
    }

    /**
     * Return Authentication Headers
     *
     * @param request
     * @return
     */
    private Map<String, String> getAuthHeaders(Request request) {
        Map<String, String> headers = new HashMap<>();
        AccessToken accessToken = this.getAccessToken();

        if (request.getAccessToken() != null) {
            accessToken = request.getAccessToken();
        }

        if (accessToken != null) {
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
