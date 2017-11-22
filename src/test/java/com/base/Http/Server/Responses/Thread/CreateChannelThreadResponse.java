package com.base.Http.Server.Responses.Thread;

import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Http.Server.Responses.BaseResponse;
import com.base.Models.Thread;

public class CreateChannelThreadResponse extends BaseResponse {

    public static String VALID_SUBJECT = "Deploy to AWS ECS 2";
    public static String VALID_DESCRIPTION = "We need to Deploy the app on AWS ECS.";
    public static String VALID_CHANNEL_SLUG = "development";
    public static String VALID_TEAM_SLUG = "twitter";
    public static String VALID_THREAD_SLUG = "deploy-to-aws-ecs-2";
    public static String INVALID_CHANNEL_SLUG = "development-1";
    public static int VALID_ID = 1;

    @Override
    public Response getResponse(Request request, Response response) {
        return response.setStatusCode(200)
                .setBody(generateResponseBody(createThread(request)));
    }

    public Thread createThread(Request request) {
        return (Thread) (new Thread())
                .setDescription(request.getParameters().getOrDefault("description", ""))
                .setSubject(request.getParameters().getOrDefault("subject", ""))
                .setSlug(request.getParameters().getOrDefault("slug", VALID_THREAD_SLUG))
                .setId(VALID_ID);
    }
}
