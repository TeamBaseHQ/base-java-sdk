package com.base.Http.Server.Responses.TeamMember;

import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Http.Server.Responses.BaseResponse;

public class CreateTeamMemberResponse extends BaseResponse {


    public static String VALID_SLUG = "twitter-1";
    public static String VALID_USER_ID = "1";
    public static String INVALID_SLUG = "twitter-1-2-3";

    @Override
    public Response getResponse(Request request, Response response) {
        return response.setStatusCode(200)
                .setBody("");
    }
}
