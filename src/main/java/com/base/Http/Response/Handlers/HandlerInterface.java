package com.base.Http.Response.Handlers;

import com.base.Exceptions.BaseHttpException;
import com.base.Http.Response.Response;

public interface HandlerInterface {

    /**
     * Handel Interface
     *
     * @param response {@link Response}
     * @return Response
     * @throws BaseHttpException Exception
     */
    public Response handle(Response response) throws BaseHttpException;
}
