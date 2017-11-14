package com.base.Http.Clients;

import com.base.Exceptions.BaseHttpException;
import com.base.Http.Request.Request;
import com.base.Http.Response.Response;

public interface HttpClientInterface {
    /**
     * Send Request.
     *
     * @param request
     * @return Response
     * @throws BaseHttpException
     */
    public Response send(Request request, Response response) throws BaseHttpException;
}
