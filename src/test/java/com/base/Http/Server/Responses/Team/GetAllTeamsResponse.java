package com.base.Http.Server.Responses.Team;

import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Http.Server.Responses.BaseResponse;
import com.base.Models.Team;

import java.util.ArrayList;
import java.util.List;

public class GetAllTeamsResponse extends BaseResponse {

    public static String VALID_TEAM_SLUG = "twitter";
    public static String VALID_NAME = "Design";
    public static String VALID_DESCRIPTION = "Design Team for Twitter";
    public static String VALID_INVITATION_CODE = "Twitter-RD4Uccxjz0ugB2GXa94w";
    public static int VALID_ID = 1;

    public GetAllTeamsResponse() {
        super();
    }

    public GetAllTeamsResponse(String teamSlug) {
        super();
        VALID_TEAM_SLUG = teamSlug;
    }

    @Override
    public Response getResponse(Request request, Response response) {
        return response.setStatusCode(200)
                .setBody(generateResponseBody(getTeams()));
    }

    private List<Team> getTeams() {
        List<Team> teams = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            teams.add((Team) new Team().setInvitation_code(VALID_INVITATION_CODE)
                    .setName(GetAllTeamsResponse.VALID_NAME.concat(" " + i))
                    .setDescription(GetAllTeamsResponse.VALID_DESCRIPTION)
                    .setSlug(GetAllTeamsResponse.VALID_TEAM_SLUG.concat("-" + i))
                    .setId(GetAllTeamsResponse.VALID_ID));
        }
        return teams;
    }
}
