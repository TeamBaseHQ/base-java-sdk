package com.base.Http.Server.Responses.User;

import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Http.Server.Responses.BaseResponse;
import com.base.Models.User;

public class GetUserResponse extends BaseResponse {

    public static int VALID_USER_ID = 1;
    public static String USER_NAME = "John Doe";
    public static String USER_EMAIL = "john@example.com";

    public GetUserResponse() {
        super();
    }

    public GetUserResponse(int valid_user_id) {
        super();
        VALID_USER_ID = valid_user_id;
    }

    @Override
    public Response getResponse(Request request, Response response) {
        // Success Response
        return response.setStatusCode(200)
                .setBody(generateResponseBody(getUser()));
    }

    public User getUser() {
        return (User) (new User())
                .setName(USER_NAME)
                .setEmail(USER_EMAIL)
                .setIsVerified(true)
                .setId(VALID_USER_ID);
    }
}
