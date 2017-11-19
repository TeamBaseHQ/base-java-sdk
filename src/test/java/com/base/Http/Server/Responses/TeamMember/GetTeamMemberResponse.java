package com.base.Http.Server.Responses.TeamMember;

import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Http.Server.Responses.BaseResponse;
import com.base.Models.User;

public class GetTeamMemberResponse extends BaseResponse {


    public static String VALID_TEAM_SLUG = "twitter";
    public static int VALID_USER_ID = 1;
    public static String VALID_USER_NAME = "Sharvil";
    public static String VALID_USER_EMAIL = "sharvilshah1996@gmail.com";

    public static String INVALID_USER_EMAIL = "sharvilshah1996@gmail.co";

    @Override
    public Response getResponse(Request request, Response response) {
        return response.setStatusCode(200)
                .setBody(generateResponseBody(getUser()));
    }

    private User getUser() {
        return (User) new User()
                .setEmail(VALID_USER_EMAIL)
                .setName(VALID_USER_NAME)
                .setId(VALID_USER_ID);
    }
}
