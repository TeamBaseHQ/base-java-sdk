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


    public Response(Request request, Map<String, String> headers, int statusCode, String body) {
        this.request = request;
        this.headers = headers;
        this.statusCode = statusCode;
        this.body = body;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
