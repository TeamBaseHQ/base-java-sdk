package com.base;

import com.base.Http.Server.Responses.Channel.*;
import com.base.Http.Server.Responses.ChannelMember.CreateChannelMemberResponse;
import com.base.Http.Server.Responses.ChannelMember.DeleteChannelMemberResponse;
import com.base.Http.Server.Responses.ChannelMember.GetAllChannelMembersResponse;
import com.base.Http.Server.Responses.ChannelMember.GetChannelMemberResponse;
import com.base.Http.Server.Responses.ServerResponseInterface;
import com.base.Http.Server.Responses.Team.*;
import com.base.Http.Server.Responses.TeamMember.CreateTeamMemberResponse;
import com.base.Http.Server.Responses.TeamMember.DeleteTeamMemberResponse;
import com.base.Http.Server.Responses.TeamMember.GetAllTeamMembersResponse;
import com.base.Http.Server.Responses.TeamMember.GetTeamMemberResponse;
import com.base.Http.Server.Responses.Thread.CreateChannelThreadResponse;
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
        registerTeamMemberMappings();
        registerChannelMemberMappings();
        registerThreadMappings();
    }

    private void registerThreadMappings() {
        routes.put("POST localhost/teams/".concat(CreateChannelThreadResponse.VALID_TEAM_SLUG)
                .concat("/channels/").concat(CreateChannelThreadResponse.VALID_CHANNEL_SLUG)
                .concat("/threads"), new CreateChannelThreadResponse());
    }

    private void registerChannelMemberMappings() {
        routes.put("POST localhost/teams/".concat(CreateChannelMemberResponse.VALID_TEAM_SLUG)
                .concat("/channels/").concat(CreateChannelMemberResponse.VALID_CHANNEL_SLUG)
                .concat("/members"), new CreateChannelMemberResponse());

        routes.put("GET localhost/teams/".concat(GetChannelMemberResponse.VALID_TEAM_SLUG)
                        .concat("/channels/").concat(GetChannelMemberResponse.VALID_CHANNEL_SLUG)
                        .concat("/members/").concat(String.valueOf(GetChannelMemberResponse.VALID_USER_ID)),
                new GetChannelMemberResponse());

        routes.put("GET localhost/teams/".concat(GetAllChannelMembersResponse.VALID_TEAM_SLUG)
                .concat("/channels/").concat(GetAllChannelMembersResponse.VALID_CHANNEL_SLUG)
                .concat("/members"), new GetAllChannelMembersResponse());

        routes.put("DELETE localhost/teams/".concat(DeleteChannelMemberResponse.VALID_TEAM_SLUG)
                        .concat("/channels/").concat(DeleteChannelMemberResponse.VALID_CHANNEL_SLUG)
                        .concat("/members/").concat(String.valueOf(DeleteChannelMemberResponse.VALID_USER_ID)),
                new DeleteChannelMemberResponse());
    }

    private void registerTeamMemberMappings() {
        routes.put("POST localhost/teams/".concat(CreateTeamMemberResponse.VALID_SLUG).concat("/members"), new CreateTeamMemberResponse());
        routes.put("GET localhost/teams/".concat(GetTeamMemberResponse.VALID_TEAM_SLUG).concat("/members/").concat(GetTeamMemberResponse.VALID_USER_ID + ""),
                new GetTeamMemberResponse());
        routes.put("GET localhost/teams/".concat(GetAllTeamMembersResponse.VALID_TEAM_SLUG).concat("/members"), new GetAllTeamMembersResponse());
        routes.put("DELETE localhost/teams/".concat(DeleteTeamMemberResponse.VALID_TEAM_SLUG).concat("/members/")
                .concat(DeleteTeamMemberResponse.VALID_USER_ID), new DeleteTeamMemberResponse());
    }

    private void registerTeamMapping() {
        routes.put("POST localhost/teams", new CreateTeamResponse());
        routes.put("GET localhost/teams/" + GetTeamResponse.VALID_TEAM_SLUG,
                new GetTeamResponse());
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
