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
     * Construct {@link InputError} with specified code, message and response.
     *
     * @param code     Status Code
     * @param message  Error Messsage
     * @param response {@link Response}
     */
    public InputError(int code, String message, Response response) {
        super(code, message, response);
    }

    /**
     * Return the Value of {@link ErrorBag}
     *
     * @return ErrorBag
     */
    public ErrorBag getErrorBag() {
        return errorBag;
    }

    /**
     * Set {@link ErrorBag}
     *
     * @param errorBag
     * @return
     */
    public InputError setErrorBag(ErrorBag errorBag) {
        this.errorBag = errorBag;
        return this;
    }
}
