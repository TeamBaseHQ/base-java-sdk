package com.base.Exceptions.Http;

import com.base.Exceptions.BaseHttpException;
import com.base.Http.Response.Response;

public class NotFound extends BaseHttpException {

    /**
     * Construct {@link NotFound} with Status code , Error Message and Response
     *
     * @param code     Status Code
     * @param message  Error Message
     * @param response Response
     */
    public NotFound(int code, String message, Response response) {
        super(code, message, response);
    }
}
