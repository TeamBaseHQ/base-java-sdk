package com.base.Http.Clients;

import com.base.Exceptions.BaseHttpException;
import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Http.Server.TestHttpServer;

public class TestHttpClient implements HttpClientInterface {

    private final TestHttpServer server;

    public TestHttpClient(TestHttpServer server) {
        this.server = server;
    }

    @Override
    public Response send(Request request, Response response) throws BaseHttpException {
        if (response == null) {
            response = new Response(request);
        }

        return this.server.handle(request, response);
    }
}
