package com.base.Http.Server.Responses.Team;

import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Http.Server.Responses.BaseResponse;
import com.base.Models.Message;

import java.util.ArrayList;
import java.util.List;

public class ListStaredMessagesResponse extends BaseResponse {

    public static String VALID_TEAM_SLUG = "twitter";
    public static String VALID_CONTENT = "Let's Meet...";
    public static String VALID_MESSAGE_SLUG = "elmy4c4S-5-3btL7Sf";
    public static String VALID_SENDER_TYPE = "Base\\\\Models\\\\User";
    public static String VALID_SENDER_ID = "";
    public static String VALID_TYPE = "text";

    public static int VALID_ID = 1;

    public ListStaredMessagesResponse() {
        super();
    }

    public ListStaredMessagesResponse(String teamSlug) {
        super();
        VALID_TEAM_SLUG = teamSlug;
    }

    @Override
    public Response getResponse(Request request, Response response) {
        return response.setStatusCode(200)
                .setBody(generateResponseBody(getTeam()));
    }

    public List<Message> getTeam() {
        List<Message> messages = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            messages.add((Message) new Message().setContent("")
                    .setThread_id(ListStaredMessagesResponse.VALID_TEAM_SLUG.concat("" + i))
                    .setContent(ListStaredMessagesResponse.VALID_CONTENT)
                    .setSlug(ListStaredMessagesResponse.VALID_MESSAGE_SLUG.concat("" + i))
                    .setSender_id(ListStaredMessagesResponse.VALID_SENDER_ID.concat("" + i))
                    .setSender_type(ListStaredMessagesResponse.VALID_SENDER_TYPE)
                    .setType(ListStaredMessagesResponse.VALID_TYPE)
                    .setId(VALID_ID + i));
        }
        return messages;
    }
}

