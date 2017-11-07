package com.base.Exceptions.Http;

import com.base.Exceptions.BaseHttpException;

public class NotFound extends BaseHttpException {
    public NotFound(int code, String message) {
        super(code, message);
    }
}
