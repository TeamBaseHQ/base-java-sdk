package com.base.Http.Response.Handlers;

import com.base.Exceptions.BaseHttpException;
import com.base.Http.Response.Response;

public interface HandlerInterface {

    public Response handle(Response response) throws BaseHttpException;
}
