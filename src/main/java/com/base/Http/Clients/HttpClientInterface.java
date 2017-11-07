package com.base.Http.Clients;

import com.base.Exceptions.BaseHttpException;
import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.sun.istack.internal.Nullable;

public interface HttpClientInterface {
    /**
     * Send Request.
     *
     * @param request
     * @return
     * @throws BaseHttpException
     */
    public Response send(Request request, @Nullable Response response) throws BaseHttpException;
}
