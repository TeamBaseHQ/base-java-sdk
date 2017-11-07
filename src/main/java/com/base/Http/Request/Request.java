package com.base.Http.Request;

import com.base.Auth.AccessToken;

import java.io.File;
import java.util.List;
import java.util.Map;

public class Request {
    /**
     * Request Method GET
     */
    public static final String METHOD_GET = "GET";

    /**
     * Request Method POST
     */
    public static final String METHOD_POST = "POST";

    /**
     * Request Method PUT
     */
    public static final String METHOD_PUT = "PUT";

    /**
     * Request Method PATCH
     */
    public static final String METHOD_PATCH = "PATCH";

    /**
     * Request Method DELETE
     */
    public static final String METHOD_DELETE = "DELETE";

    /**
     * Request endpoint
     */
    protected String endpoint;

    /**
     * Request url
     */
    protected String url;

    /**
     * Request method
     */
    protected String method;

    /**
     * Request headers
     */
    protected Map<String, String> headers;

    /**
     * Request parameters
     */
    protected Map<String, String> parameters;

    /**
     * Request body
     */
    protected RequestBody body;

    /**
     * Content type
     */
    protected String contentType = "application/json; charset=utf-8";

    /**
     * Files
     */
    protected Map<String, File> files;

    /**
     * Access Token
     */
    protected AccessToken accessToken;

    /**
     * Create new Request.
     *
     * @param endpoint
     * @param method
     */
    public Request(String endpoint, String method) {
        this.endpoint = endpoint;
        this.method = method;
    }

    /**
     * Get Request Endpoint.
     *
     * @return Request Endpoint.
     */
    public String getEndpoint() {
        return endpoint;
    }

    /**
     * Get Request Method.
     *
     * @return Request Method.
     */
    public String getMethod() {
        return method;
    }

    /**
     * Get Request Headers.
     *
     * @return Request Headers.
     */
    public Map<String, String> getHeaders() {
        return headers;
    }

    /**
     * Get Request Parameters.
     *
     * @return Request Parameters.
     */
    public Map<String, String> getParameters() {
        return parameters;
    }

    /**
     * Get Request Body.
     *
     * @return Request Body.
     */
    public RequestBody getBody() {
        return body;
    }

    /**
     * Set Endpoint.
     *
     * @param endpoint
     * @return
     */
    public Request setEndpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    /**
     * Set Method.
     *
     * @param method
     * @return
     */
    public Request setMethod(String method) {
        this.method = method;
        return this;
    }

    /**
     * Set Headers.
     *
     * @param headers
     * @return
     */
    public Request setHeaders(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    /**
     * Set Parameters.
     *
     * @param parameters
     * @return
     */
    public Request setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
        return this;
    }

    /**
     * Set Body.
     *
     * @param body
     * @return
     */
    public Request setBody(RequestBody body) {
        this.body = body;
        return this;
    }

    public String getContentType() {
        return contentType;
    }

    public Request setContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    public Map<String, File> getFiles() {
        return files;
    }

    public Request setFiles(Map<String, File> files) {
        this.files = files;
        return this;
    }

    public Request addFile(String key, File file) {
        this.files.put(key, file);
        return this;
    }

    public boolean hasFiles() {
        return !this.files.isEmpty();
    }

    public String getUrl() {
        return url;
    }

    public Request setUrl(String url) {
        this.url = url;
        return this;
    }

    public AccessToken getAccessToken() {
        return accessToken;
    }

    public Request setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
        return this;
    }
}
