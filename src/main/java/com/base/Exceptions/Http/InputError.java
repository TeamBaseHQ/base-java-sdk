package com.base.Exceptions.Http;

import com.base.Exceptions.BaseHttpException;
import com.base.Http.Response.ErrorBag;
import com.base.Http.Response.Response;

public class InputError extends BaseHttpException {

    protected ErrorBag errorBag;

    public InputError(int code, String message, Response response) {
        super(code, message, response);
    }

    public ErrorBag getErrorBag() {
        return errorBag;
    }

    public InputError setErrorBag(ErrorBag errorBag) {
        this.errorBag = errorBag;
        return this;
    }
}
