package com.base.Exceptions;

import com.base.Http.Response.Response;

public class BaseHttpException extends BaseException {

    /**
     * HTTP {@link Response}
     */
    protected Response response;

    /**
     * Constructs {@link BaseHttpException} with the specified code,message and response
     * @param code Status Code
     * @param message Error Message
     * @param response Response
     */
    public BaseHttpException(int code, String message, Response response) {
        super(code, message);
        this.response = response;
    }

    /**
     * Get the {@link Response}
     * @return Response
     */
    public Response getResponse() {
        return response;
    }

    /**
     * Construct {@link BaseHttpException} with response.
     * @param response Response
     * @return
     */
    public BaseHttpException setResponse(Response response) {
        this.response = response;
        return this;
    }
}
