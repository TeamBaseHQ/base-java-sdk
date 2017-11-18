package com.base.Http.Server.Responses.Team;

import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Http.Server.Responses.BaseResponse;
import com.base.Models.Team;

public class CreateTeamResponse extends BaseResponse {

    public static String VALID_NAME = "Twitter";
    public static String VALID_DESCRIPTION = "Twitter Team";
    public static String VALID_INVITATION_CODE = "Twitter-RD4Uccxjz0ugB2GXa94w";
    public static String VALID_SLUG = "twitter-1";

    @Override
    public Response getResponse(Request request, Response response) {
        return response.setStatusCode(200)
                .setBody(generateResponseBody(createTeam(request)));
    }

    public Team createTeam(Request request) {
        return (Team) (new Team())
                .setDescription(request.getParameters().getOrDefault("description", ""))
                .setName(request.getParameters().getOrDefault("name", ""))
                .setSlug(request.getParameters().getOrDefault("slug", VALID_SLUG))
                .setInvitation_code(request.getParameters().getOrDefault("invitation_code", VALID_INVITATION_CODE));
    }
}
