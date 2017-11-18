package com.base.Http.Server.Responses.Channel;

import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Http.Server.Responses.BaseResponse;
import com.base.Models.Channel;

import java.util.ArrayList;
import java.util.List;

public class GetAllChannelsResponse extends BaseResponse {

    public static String VALID_TEAM_SLUG = "twitter";
    public static String VALID_CHANNEL_SLUG = "design";
    public static String VALID_NAME = "Design";
    public static String VALID_DESCRIPTION = "Design Channel for Twitter";
    public static String VALID_COLOR = "000000";
    public static String VALID_STATUS = "1";

    public GetAllChannelsResponse() {
        super();
    }

    public GetAllChannelsResponse(String teamSlug, String channelSlug) {
        super();
        VALID_CHANNEL_SLUG = channelSlug;
        VALID_TEAM_SLUG = teamSlug;
    }

    @Override
    public Response getResponse(Request request, Response response) {
        return response.setStatusCode(200)
                .setBody(generateResponseBody(getChannels()));
    }

    private List<Channel> getChannels() {
        List<Channel> channels = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            channels.add(new Channel().setColor(GetAllChannelsResponse.VALID_COLOR)
                    .setName(GetAllChannelsResponse.VALID_NAME.concat(" " + i))
                    .setDescription(GetAllChannelsResponse.VALID_DESCRIPTION)
                    .setIs_private(GetAllChannelsResponse.VALID_STATUS)
                    .setSlug(GetAllChannelsResponse.VALID_CHANNEL_SLUG.concat("-" + i)));
            System.out.println(GetAllChannelsResponse.VALID_NAME.concat(" " + i));
            System.out.println(GetAllChannelsResponse.VALID_CHANNEL_SLUG.concat("-" + i));
        }
        return channels;
    }
}
