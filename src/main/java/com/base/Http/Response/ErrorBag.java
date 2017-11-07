package com.base.Http.Response;

import java.util.Map;

public class ErrorBag {

    protected String message;

    protected Map<String, String[]> errors;

    public String getMessage() {
        return message;
    }

    public ErrorBag setMessage(String message) {
        this.message = message;
        return this;
    }

    public Map<String, String[]> getErrors() {
        return errors;
    }

    public ErrorBag setErrors(Map<String, String[]> errors) {
        this.errors = errors;
        return this;
    }
}
