package com.base.Http.Clients;

import com.base.Exceptions.BaseHttpException;
import com.base.Http.Request.Request;
import com.base.Http.Response.Response;

public interface HttpClientInterface {
    /**
     * Send Request.
     *
     * @param request
     * @throws BaseHttpException
     * @return
     */
    public Response send(Request request) throws BaseHttpException;
}
