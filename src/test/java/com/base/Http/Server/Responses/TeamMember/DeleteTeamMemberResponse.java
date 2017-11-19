package com.base.Http.Server.Responses.TeamMember;

import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Http.Server.Responses.BaseResponse;

public class DeleteTeamMemberResponse extends BaseResponse {

    public static String VALID_TEAM_SLUG = "twitter";
    public static String VALID_DELETED_TEAM_SLUG = "design";
    public static String VALID_USER_ID = "1";

    @Override
    public Response getResponse(Request request, Response response) {
        return response.setStatusCode(200)
                .setBody("");
    }
}
