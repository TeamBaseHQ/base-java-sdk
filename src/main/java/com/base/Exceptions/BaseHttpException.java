package com.base.Exceptions;

import com.base.Http.Response.Response;

public class BaseHttpException extends BaseException {

    protected Response response;

    public BaseHttpException(int code, String message, Response response) {
        super(code, message);
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }

    public BaseHttpException setResponse(Response response) {
        this.response = response;
        return this;
    }
}
