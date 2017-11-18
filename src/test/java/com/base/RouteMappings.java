package com.base;

import com.base.Http.Server.Responses.Channel.*;
import com.base.Http.Server.Responses.ServerResponseInterface;
import com.base.Http.Server.Responses.Team.*;
import com.base.Http.Server.Responses.User.GetUserResponse;
import com.base.Http.Server.Responses.User.UserLoginResponse;

import java.util.HashMap;
import java.util.Map;

public class RouteMappings {

    public static Map<String, ServerResponseInterface> routes = new HashMap<>();

    public RouteMappings() {
        registerUserMappings();
        registerChannelMappings();
        registerTeamMapping();
    }

    private void registerTeamMapping() {
        routes.put("POST localhost/teams", new CreateTeamResponse());
        routes.put("GET localhost/teams/" + GetTeamResponse.VALID_TEAM_SLUG,
                new GetUserResponse());
        routes.put("GET localhost/teams", new GetAllTeamsResponse());
        routes.put("PATCH localhost/teams/".concat(UpdateTeamResponse.VALID_SLUG), new UpdateTeamResponse());
        routes.put("DELETE localhost/teams/".concat(DeleteChannelResponse.VALID_TEAM_SLUG), new DeleteChannelResponse());
        routes.put("GET localhost/teams/".concat(ListStaredMessagesResponse.VALID_TEAM_SLUG.concat("/starred-messages")), new ListStaredMessagesResponse());
    }

    private void registerUserMappings() {
        routes.put("POST localhost/users/login", new UserLoginResponse());
        routes.put("GET localhost/users/" + String.valueOf(GetUserResponse.VALID_USER_ID),
                new GetUserResponse());
    }

    private void registerChannelMappings() {
        routes.put("POST localhost/teams/".concat(CreateChannelResponse.VALID_TEAM_SLUG).concat("/channels"),
                new CreateChannelResponse());
        routes.put("GET localhost/teams/".concat(GetChannelResponse.VALID_TEAM_SLUG).concat("/channels/").concat(GetChannelResponse.VALID_CHANNEL_SLUG),
                new GetChannelResponse());
        routes.put("GET localhost/teams/".concat(GetAllChannelsResponse.VALID_TEAM_SLUG).concat("/channels"), new GetAllChannelsResponse());
        routes.put("PATCH localhost/teams/".concat(UpdateChannelResponse.VALID_TEAM_SLUG).concat("/channels/".concat(UpdateChannelResponse.VALID_CHANNEL_SLUG)),
                new UpdateChannelResponse());
        routes.put("DELETE localhost/teams/".concat(DeleteChannelResponse.VALID_TEAM_SLUG).concat("/channels/".concat(DeleteChannelResponse.VALID_CHANNEL_SLUG)),
                new DeleteChannelResponse());
    }

    public Map<String, ServerResponseInterface> getRoutes() {
        return routes;
    }
}
