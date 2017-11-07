package com.base.Http.Request;

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
     * Create new Request.
     *
     * @param url
     * @param method
     */
    public Request(String url, String method) {
        this.url = url;
        this.method = method;
    }

    /**
     * Get Request Url.
     *
     * @return Request Url.
     */
    public String getUrl() {
        return url;
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
     * Set Url.
     * @param url
     * @return
     */
    public Request setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * Set Method.
     * @param method
     * @return
     */
    public Request setMethod(String method) {
        this.method = method;
        return this;
    }

    /**
     * Set Headers.
     * @param headers
     * @return
     */
    public Request setHeaders(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    /**
     * Set Parameters.
     * @param parameters
     * @return
     */
    public Request setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
        return this;
    }

    /**
     * Set Body.
     * @param body
     * @return
     */
    public Request setBody(RequestBody body) {
        this.body = body;
        return this;
    }
}
