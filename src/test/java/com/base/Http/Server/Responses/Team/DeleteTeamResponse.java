package com.base.Http.Server.Responses.Team;

import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Http.Server.Responses.BaseResponse;

public class DeleteTeamResponse extends BaseResponse {

    public static String VALID_TEAM_SLUG = "twitter";
    public static String VALID_DELETED_TEAM_SLUG = "design";

    @Override
    public Response getResponse(Request request, Response response) {
        return response.setStatusCode(200)
                .setBody("");
    }
}
