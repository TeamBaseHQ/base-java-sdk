package com.base.Http.Server;

import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Http.Server.Responses.NotFoundResponse;
import com.base.Http.Server.Responses.ServerResponseInterface;

import java.util.HashMap;
import java.util.Map;

public class TestHttpServer {

    private static Map<String, ServerResponseInterface> routeMappings;

    public TestHttpServer() {
        TestHttpServer.routeMappings = new HashMap<>();
    }

    public TestHttpServer(Map<String, ServerResponseInterface> mappings) {
        TestHttpServer.routeMappings = mappings;
    }

    public Response handle(Request request, Response response) {
        ServerResponseInterface responseFromServer = TestHttpServer.getServerResponse(request.getMethod(), request.getUrl());

        if (responseFromServer == null) {
           ServerResponseInterface res = new NotFoundResponse();
           return res.getResponse(request, response);
        }

        return responseFromServer.getResponse(request, response);
    }

    private static ServerResponseInterface getServerResponse(String method, String url) {
        String signature = method.concat(" ").concat(url);
        return TestHttpServer.routeMappings.getOrDefault(signature, null);
    }
}
