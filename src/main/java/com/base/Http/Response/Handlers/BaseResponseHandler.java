package com.base.Http.Response.Handlers;

import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.Http.InputError;
import com.base.Exceptions.Http.NotFound;
import com.base.Http.Response.ErrorBag;
import com.base.Http.Response.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BaseResponseHandler implements HandlerInterface {

    /**
     * It will take Response as argument.
     * It will throw {@link NotFound} Exception when Response's StatusCode is equals-to 404
     * and throw {@link BaseResponseHandler.inputError} Exception if StatusCode is equals-to 422
     * else it will throw {@link BaseHttpException}
     *
     * @param response
     * @throws BaseHttpException
     */
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

    /**
     * Throw An Exception according to status code
     *
     * @param statusCode Request's status code
     * @param message    Request's Message
     * @param response   Response
     * @return BaseHttpException exception
     */
    private static BaseHttpException inputError(int statusCode, String message, Response response) {
        InputError error = new InputError(statusCode, message, response);
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        ErrorBag errorBag = gson.fromJson(response.getBody(), ErrorBag.class);
        error.setErrorBag(errorBag);

        return error;
    }

    /**
     * It will throw an exception when Response's StatusCode is grater than or equal to 400.
     *
     * @param response {@link Response}
     * @return Response
     * @throws BaseHttpException Exception
     */
    public Response handle(Response response) throws BaseHttpException {
        int code = response.getStatusCode();

        if (code >= 400) {
            BaseResponseHandler.throwException(response);
        }

        return response;
    }

}
