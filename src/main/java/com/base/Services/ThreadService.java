package com.base.Services;

import com.base.Base;
import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.ChannelNotFound;
import com.base.Exceptions.Http.NotFound;
import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Models.Thread;

import java.util.*;

public class ThreadService {
    private Base base;

    public ThreadService(Base base) {
        this.base = base;
    }

    /**
     * Create Thread Messages
     *
     * @param teamSlug    Team Slug Name
     * @param channelSlug Channel Slug Name
     * @param subject     Thread subject
     * @param description Thread description
     * @return Thread
     * @throws BaseHttpException Exception
     * @throws ChannelNotFound   Exception
     */
    public Thread createThreadMessage(String teamSlug, String channelSlug, String subject, String description) throws BaseHttpException, ChannelNotFound {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("subject", subject);
        parameters.put("description", description);
        try {
            String URL = "/teams/".concat(teamSlug).concat("/channels/").concat(channelSlug).concat("/threads");
            Response response = this.base.sendRequest(URL, Request.METHOD_POST, parameters);
            return (Thread) Base.makeModel(Thread.class, response.getBody());
        } catch (NotFound e) {
            throw new ChannelNotFound(channelSlug);
        }
    }

    /**
     * List of All Channels Threads
     *
     * @param teamSlug    Team Slug
     * @param channelSlug Channel Slug
     * @return List of Threads
     * @throws ChannelNotFound   Exception
     * @throws BaseHttpException Exception
     */
    public List<Thread> listChannelThreads(String teamSlug, String channelSlug) throws ChannelNotFound, BaseHttpException {
        try {
            String urlEndPoint = "/teams/".concat(teamSlug).concat("/channels/").concat(channelSlug).concat("/threads");
            Response response = this.base.sendRequest(urlEndPoint, Request.METHOD_GET);
            Thread[] threadsArray = (Thread[]) Base.makeModel(Thread[].class, response.getBody());
            return new ArrayList<>(Arrays.asList(threadsArray));
        } catch (NotFound e) {
            throw new ChannelNotFound(channelSlug);
        }
    }

}
