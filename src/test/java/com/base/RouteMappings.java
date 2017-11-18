package com.base;

import com.base.Http.Server.Responses.Channel.CreateChannelResponse;
import com.base.Http.Server.Responses.Channel.GetAllChannelsResponse;
import com.base.Http.Server.Responses.Channel.GetChannelResponse;
import com.base.Http.Server.Responses.Channel.UpdateChannelResponse;
import com.base.Http.Server.Responses.ServerResponseInterface;
import com.base.Http.Server.Responses.User.GetUserResponse;
import com.base.Http.Server.Responses.User.UserLoginResponse;

import java.util.HashMap;
import java.util.Map;

public class RouteMappings {

    public static Map<String, ServerResponseInterface> routes = new HashMap<>();

    public RouteMappings() {
        registerUserMappings();
        registerChannelMappings();
    }

    private void registerUserMappings() {
        routes.put("POST localhost/users/login", new UserLoginResponse());
        routes.put("GET localhost/users/" + String.valueOf(GetUserResponse.VALID_USER_ID),
                new GetUserResponse()
        );
    }

    private void registerChannelMappings() {
        routes.put("POST localhost/teams/".concat(CreateChannelResponse.VALID_TEAM_SLUG).concat("/channels"),
                new CreateChannelResponse());
        routes.put("GET localhost/teams/".concat(GetChannelResponse.VALID_TEAM_SLUG).concat("/channels/").concat(GetChannelResponse.VALID_CHANNEL_SLUG),
                new GetChannelResponse());
        routes.put("GET localhost/teams/".concat(GetAllChannelsResponse.VALID_TEAM_SLUG).concat("/channels"), new GetAllChannelsResponse());
        routes.put("POST localhost/teams/".concat(UpdateChannelResponse.VALID_TEAM_SLUG).concat("/channels/".concat(UpdateChannelResponse.VALID_CHANNEL_SLUG)),
                new UpdateChannelResponse());
    }

    public Map<String, ServerResponseInterface> getRoutes() {
        return routes;
    }
}
