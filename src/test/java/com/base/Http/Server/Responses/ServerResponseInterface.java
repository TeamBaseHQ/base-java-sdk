package com.base.Http.Server.Responses;

import com.base.Http.Request.Request;
import com.base.Http.Response.Response;

public interface ServerResponseInterface {

    /**
     * Get Response.
     *
     * @param request
     * @param response
     * @return
     */
    public Response getResponse(Request request, Response response);
}
