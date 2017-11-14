package com.base.Http.Response;

import com.base.Http.Request.Request;

import java.util.Map;

public class Response {

    /**
     * Request of this Response.
     */
    public Request request;

    /**
     * Response headers.
     */
    protected Map<String, String> headers;

    /**
     * Response Code.
     */
    protected int statusCode;

    /**
     * Response Body.
     */
    protected String body;


    /**
     * Construct Response according to {@link Request}
     *
     * @param request Request
     */
    public Response(Request request) {
        this.request = request;
    }

    /**
     * Construct response according to arguments.
     *
     * @param request    {@link Request}
     * @param headers    Request Headers
     * @param statusCode Request Status Code
     * @param body       Request Body
     */
    public Response(Request request, Map<String, String> headers, int statusCode, String body) {
        this(request);
        this.headers = headers;
        this.statusCode = statusCode;
        this.body = body;
    }

    /**
     * Return {@link Request}
     *
     * @return Request
     */
    public Request getRequest() {
        return request;
    }

    /**
     * Set Request
     *
     * @param request
     * @return
     */
    public Response setRequest(Request request) {
        this.request = request;
        return this;
    }

    /**
     * Return Headers of Request
     *
     * @return
     */
    public Map<String, String> getHeaders() {
        return headers;
    }

    /**
     * Set Headers of Request
     *
     * @param headers Request Headers
     * @return
     */
    public Response setHeaders(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    /**
     * Return Status Code of Request
     *
     * @return
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * Set Status Code of Request
     *
     * @param statusCode Request status Code of Request
     * @return
     */
    public Response setStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    /**
     * Request Body
     *
     * @return Request Body
     */
    public String getBody() {
        return body;
    }

    /**
     * Set Request Body
     *
     * @param body Request Body
     * @return
     */
    public Response setBody(String body) {
        this.body = body;
        return this;
    }
}
