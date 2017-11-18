package com.base.Http.Server.Responses.Channel;

import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Http.Server.Responses.BaseResponse;
import com.base.Models.Channel;

public class GetChannelResponse extends BaseResponse {

    public static String VALID_TEAM_SLUG = "twitter";
    public static String VALID_CHANNEL_SLUG = "design-1";
    public static String VALID_NAME = "Design";
    public static String VALID_DESCRIPTION = "Design Channel for Twitter";
    public static String VALID_COLOR = "000000";
    public static String VALID_STATUS = "1";

    public GetChannelResponse() {
        super();
    }

    public GetChannelResponse(String teamSlug, String channelSlug) {
        super();
        VALID_CHANNEL_SLUG = channelSlug;
        VALID_TEAM_SLUG = teamSlug;
    }

    @Override
    public Response getResponse(Request request, Response response) {
        return response.setStatusCode(200)
                .setBody(generateResponseBody(getChannel()));
    }

    public Channel getChannel() {
        return (Channel) new Channel()
                .setSlug(VALID_CHANNEL_SLUG)
                .setDescription(VALID_DESCRIPTION)
                .setIs_private(VALID_STATUS)
                .setColor(VALID_COLOR)
                .setName(VALID_NAME);
    }
}
