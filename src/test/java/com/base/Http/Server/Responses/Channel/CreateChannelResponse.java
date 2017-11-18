package com.base.Http.Server.Responses.Channel;

import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Http.Server.Responses.BaseResponse;
import com.base.Models.Channel;

public class CreateChannelResponse extends BaseResponse {

    public static String VALID_TEAM_SLUG = "twitter";
    public static String VALID_CHANNEL_SLUG = "design-1";
    public static String VALID_NAME = "Design";
    public static String VALID_DESCRIPTION = "Design Channel for Twitter";
    public static String VALID_COLOR = "000000";
    public static String VALID_STATUS = "1";
    public static int VALID_ID = 1;

    @Override
    public Response getResponse(Request request, Response response) {

        return response.setStatusCode(200)
                .setBody(generateResponseBody(getChannel(request)));

    }

    public Channel getChannel(Request request) {

        return (Channel) (new Channel())
                .setColor(request.getParameters().getOrDefault("color", ""))
                .setDescription(request.getParameters().getOrDefault("description", ""))
                .setName(request.getParameters().getOrDefault("name", ""))
                .setSlug(request.getParameters().getOrDefault("slug", VALID_CHANNEL_SLUG))
                .setIs_private(request.getParameters().getOrDefault("is_private", ""))
                .setId(VALID_ID);
    }
}
