package com.base.Http.Server.Responses;

import com.base.Http.Request.Request;
import com.base.Http.Response.Response;

public class NotFoundResponse implements ServerResponseInterface {
    @Override
    public Response getResponse(Request request, Response response) {
        String signature = request.getMethod().concat(" ").concat(request.getUrl());
        response.setStatusCode(404)
                .setBody("No Resource was found at ".concat(signature));

        return response;
    }
}
