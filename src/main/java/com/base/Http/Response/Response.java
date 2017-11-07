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


    public Response(Request request) {
        this.request = request;
    }

    public Response(Request request, Map<String, String> headers, int statusCode, String body) {
        this(request);
        this.headers = headers;
        this.statusCode = statusCode;
        this.body = body;
    }

    public Request getRequest() {
        return request;
    }

    public Response setRequest(Request request) {
        this.request = request;
        return this;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Response setHeaders(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Response setStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public String getBody() {
        return body;
    }

    public Response setBody(String body) {
        this.body = body;
        return this;
    }
}
