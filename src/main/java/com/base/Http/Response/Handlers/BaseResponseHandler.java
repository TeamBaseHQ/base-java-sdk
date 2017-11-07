package com.base.Http.Response.Handlers;

import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.Http.InputError;
import com.base.Exceptions.Http.NotFound;
import com.base.Http.Response.ErrorBag;
import com.base.Http.Response.Response;
import com.base.Models.ResponseModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BaseResponseHandler implements HandlerInterface {

    public Response handle(Response response) throws BaseHttpException {
        int code = response.getStatusCode();

        if (code >= 400) {
            BaseResponseHandler.throwException(response);
        }

        return response;
    }

    private static void throwException(Response response) throws BaseHttpException {
        int statusCode = response.getStatusCode();
        String message = response.getBody();

        if (statusCode == 404) {
            throw new NotFound(statusCode, message, response);
        }

        if (statusCode == 422) {
            throw BaseResponseHandler.inputError(statusCode, message, response);
        }

        throw new BaseHttpException(statusCode, message, response);
    }

    private static BaseHttpException inputError(int statusCode, String message, Response response) {
        InputError error = new InputError(statusCode, message, response);
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        ErrorBag errorBag = gson.fromJson(response.getBody(), ErrorBag.class);
        error.setErrorBag(errorBag);

        return error;
    }

}
