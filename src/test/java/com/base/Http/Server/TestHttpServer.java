package com.base.Http.Server;

import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Http.Server.Responses.NotFoundResponse;
import com.base.Http.Server.Responses.ServerResponseInterface;

import java.util.HashMap;
import java.util.Map;

public class TestHttpServer {

    /**
     * Route Mappings.
     */
    private static Map<String, ServerResponseInterface> routeMappings;

    /**
     * Create new TestHttpServer.
     */
    public TestHttpServer() {
        TestHttpServer.routeMappings = new HashMap<>();
    }

    /**
     * Create new TestHttpServer with Route Mappings.
     *
     * @param mappings Route Mappings.
     */
    public TestHttpServer(Map<String, ServerResponseInterface> mappings) {
        TestHttpServer.routeMappings = mappings;
    }

    /**
     * Handle the Request.
     *
     * @param request  Request to Handle.
     * @param response Pre-instantiated Response.
     * @return Server Response.
     */
    public Response handle(Request request, Response response) {
        // Fetch (Dummy) Response from Server.
        ServerResponseInterface responseFromServer =
                TestHttpServer.getServerResponse(
                        request.getMethod(),
                        request.getUrl()
                );

        // No Response was fetched.
        if (responseFromServer == null) {
            ServerResponseInterface res = new NotFoundResponse();
            return res.getResponse(request, response);
        }

        // Get Response.
        return responseFromServer.getResponse(request, response);
    }

    /**
     * Fetch Response for the given method-url combo.
     *
     * @param method Request Method. (GET|PUT|PATCH|POST|UPDATE|DELETE)
     * @param url Request URL.
     * @return (Dummy) Server Response.
     */
    private static ServerResponseInterface getServerResponse(String method, String url) {
        String signature = method.concat(" ").concat(url);
        return TestHttpServer.routeMappings.getOrDefault(signature, null);
    }
}
