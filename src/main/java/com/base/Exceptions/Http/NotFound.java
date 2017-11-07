package com.base.Exceptions.Http;

import com.base.Exceptions.BaseHttpException;
import com.base.Http.Response.Response;

public class NotFound extends BaseHttpException {

    public NotFound(int code, String message, Response response) {
        super(code, message, response);
    }
}
