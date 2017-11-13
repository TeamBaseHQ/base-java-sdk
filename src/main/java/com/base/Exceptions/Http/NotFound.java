package com.base.Exceptions.Http;

import com.base.Exceptions.BaseHttpException;
import com.base.Http.Response.Response;

public class NotFound extends BaseHttpException {

    /**
     * Not Found Exception Class
     * @param code
     * @param message
     * @param response
     */
    public NotFound(int code, String message, Response response) {
        super(code, message, response);
    }
}
