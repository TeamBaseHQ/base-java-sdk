package com.base;

import com.base.Http.Server.Responses.ServerResponseInterface;
import com.base.Http.Server.Responses.User.UserLoginResponse;

import java.util.HashMap;
import java.util.Map;

public class RouteMappings {

    public static Map<String, ServerResponseInterface> routes = new HashMap<>();

    public RouteMappings() {
        routes.put("POST localhost/users/login", new UserLoginResponse());
    }

    public Map<String, ServerResponseInterface> getRoutes() {
        return routes;
    }
}
