package com.base.Http.Server.Responses.ChannelMember;

import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Http.Server.Responses.BaseResponse;

public class DeleteChannelMemberResponse extends BaseResponse {

    public static String VALID_TEAM_SLUG = "twitter";
    public static String VALID_CHANNEL_SLUG = "design";
    public static String VALID_DELETED_TEAM_SLUG = "twitter-1";
    public static String VALID_USER_ID = "1";

    @Override
    public Response getResponse(Request request, Response response) {
        return response.setStatusCode(200)
                .setBody("");
    }
}
