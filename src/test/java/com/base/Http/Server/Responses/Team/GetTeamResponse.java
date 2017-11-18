package com.base.Http.Server.Responses.Team;

import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Http.Server.Responses.BaseResponse;
import com.base.Models.Team;

public class GetTeamResponse extends BaseResponse {

    public static String VALID_TEAM_SLUG = "twitter";
    public static String VALID_NAME = "Twitter";
    public static String VALID_DESCRIPTION = "Design Team for Twitter";
    public static String VALID_INVITATION_CODE = "Twitter-RD4Uccxjz0ugB2GXa94w";
    public static int VALID_ID = 1;

    public GetTeamResponse() {
        super();
    }

    public GetTeamResponse(String teamSlug) {
        super();
        VALID_TEAM_SLUG = teamSlug;
    }

    @Override
    public Response getResponse(Request request, Response response) {
        return response.setStatusCode(200)
                .setBody(generateResponseBody(getTeam()));
    }

    public Team getTeam() {
        return (Team) new Team()
                .setSlug(VALID_TEAM_SLUG)
                .setDescription(VALID_DESCRIPTION)
                .setName(VALID_NAME)
                .setInvitation_code(VALID_INVITATION_CODE)
                .setId(VALID_ID);
    }
}

