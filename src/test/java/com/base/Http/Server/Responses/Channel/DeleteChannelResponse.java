package com.base.Http.Server.Responses.Channel;

import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Http.Server.Responses.BaseResponse;

public class DeleteChannelResponse extends BaseResponse {

    public static String VALID_TEAM_SLUG = "twitter";
    public static String VALID_CHANNEL_SLUG = "design-1";
    public static String VALID_DELETED_CHANNEL_SLUG = "design-1";

    @Override
    public Response getResponse(Request request, Response response) {
        return response.setStatusCode(200)
                .setBody("");
    }
}
