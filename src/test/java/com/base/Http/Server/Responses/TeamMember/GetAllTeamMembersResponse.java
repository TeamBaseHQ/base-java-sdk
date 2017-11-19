package com.base.Http.Server.Responses.TeamMember;

import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Http.Server.Responses.BaseResponse;
import com.base.Models.User;

import java.util.ArrayList;
import java.util.List;

public class GetAllTeamMembersResponse extends BaseResponse {

    public static String VALID_TEAM_SLUG = "twitter";
    public static int VALID_USER_ID = 0;
    public static String VALID_USER_NAME = "Sharvil";

    public GetAllTeamMembersResponse() {
        super();
    }

    public GetAllTeamMembersResponse(String teamSlug) {
        super();
        VALID_TEAM_SLUG = teamSlug;
    }

    @Override
    public Response getResponse(Request request, Response response) {
        return response.setStatusCode(200)
                .setBody(generateResponseBody(getUsers()));
    }

    private List<User> getUsers() {
        List<User> users = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            users.add((User) new User()
                    .setEmail(VALID_USER_NAME + i + "@gmail.com")
                    .setName(VALID_USER_NAME + "i")
                    .setId(VALID_USER_ID + i));
        }

        return users;
    }
}

