package com.base.Exceptions;

public class BaseHttpException extends BaseException {

    public BaseHttpException(int code, String message) {
        super(code, message);
    }
}
