package com.base;

import com.base.Http.Server.Responses.Channel.CreateChannelResponse;
import com.base.Http.Server.Responses.ServerResponseInterface;
import com.base.Http.Server.Responses.User.GetUserResponse;
import com.base.Http.Server.Responses.User.UserLoginResponse;

import java.util.HashMap;
import java.util.Map;

public class RouteMappings {

    public static Map<String, ServerResponseInterface> routes = new HashMap<>();

    public RouteMappings() {
        registerUserMappings();
    }

    private void registerUserMappings() {
        routes.put("POST localhost/users/login", new UserLoginResponse());
        routes.put("GET localhost/users/" + String.valueOf(GetUserResponse.VALID_USER_ID),
                new GetUserResponse()
        );
        routes.put("POST localhost/teams/".concat(CreateChannelResponse.VALID_TEAM_SLUG).concat("/channels"),
                new CreateChannelResponse());
    }

    public Map<String, ServerResponseInterface> getRoutes() {
        return routes;
    }
}
