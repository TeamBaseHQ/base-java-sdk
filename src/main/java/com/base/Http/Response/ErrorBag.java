package com.base.Http.Response;

import java.util.Map;

public class ErrorBag {

    /**
     * Error's Message
     */
    protected String message;

    /**
     * Map of Errors
     */
    protected Map<String, String[]> errors;

    /**
     * Return Error Message
     *
     * @return Message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set Error Message
     *
     * @param message
     * @return
     */
    public ErrorBag setMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * Return Errors's Map
     *
     * @return
     */
    public Map<String, String[]> getErrors() {
        return errors;
    }

    /**
     * Set Errors
     *
     * @param errors
     * @return
     */
    public ErrorBag setErrors(Map<String, String[]> errors) {
        this.errors = errors;
        return this;
    }
}
