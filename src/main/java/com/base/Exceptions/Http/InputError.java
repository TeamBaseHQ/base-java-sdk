package com.base.Exceptions.Http;

import com.base.Exceptions.BaseHttpException;
import com.base.Http.Response.ErrorBag;
import com.base.Http.Response.Response;

public class InputError extends BaseHttpException {

    /**
     * ErrorBag
     */
    protected ErrorBag errorBag;

    /**
     * Default Constructor
     * @param code
     * @param message
     * @param response
     */
    public InputError(int code, String message, Response response) {
        super(code, message, response);
    }

    /**
     * Get ErrorBag
     * @return ErrorBag
     */
    public ErrorBag getErrorBag() {
        return errorBag;
    }

    /**
     * Set ErrorBag
     * @param errorBag
     * @return
     */
    public InputError setErrorBag(ErrorBag errorBag) {
        this.errorBag = errorBag;
        return this;
    }
}
