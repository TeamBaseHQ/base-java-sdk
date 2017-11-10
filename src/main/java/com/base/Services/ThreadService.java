package com.base.Services;

import com.base.Base;
import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.ChannelNotFound;
import com.base.Exceptions.Http.NotFound;
import com.base.Exceptions.ThreadNotFound;
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
            String URL = "/teams/".concat(teamSlug).concat("/channels/").concat(channelSlug).concat("/threads");
            Response response = this.base.sendRequest(URL, Request.METHOD_GET);
            Thread[] threadsArray = (Thread[]) Base.makeModel(Thread[].class, response.getBody());
            return new ArrayList<>(Arrays.asList(threadsArray));
        } catch (NotFound e) {
            throw new ChannelNotFound(channelSlug);
        }
    }

    /**
     * Show Channel's Thread
     *
     * @param teamSlug    Team Slug Name
     * @param channelSlug Channel Slug Name
     * @param threadSlug  Thread Slug Name
     * @return Thread
     * @throws ThreadNotFound
     * @throws BaseHttpException
     */
    public Thread showChannelThread(String teamSlug, String channelSlug, String threadSlug) throws ThreadNotFound, BaseHttpException {
        try {
            String URL = "/teams/".concat(teamSlug).concat("/channels/").concat(channelSlug).concat("/threads/").concat(threadSlug);
            Response response = this.base.sendRequest(URL, Request.METHOD_GET);
            return (Thread) Base.makeModel(Thread.class, response.getBody());
        } catch (NotFound e) {
            throw new ThreadNotFound(threadSlug);
        }
    }

    /**
     * Delete Thread Channel
     *
     * @param teamSlug    Team Slug Name
     * @param channelSlug Channel Slug
     * @param threadSlug  Thread Slug Name
     * @throws ThreadNotFound    Exception
     * @throws BaseHttpException Exception
     */
    public boolean deleteChannelThread(String teamSlug, String channelSlug, String threadSlug) throws ThreadNotFound, BaseHttpException {

        try {
            String URL = "/teams/".concat(teamSlug).concat("/channels/").concat(channelSlug).concat("/threads/").concat(threadSlug);
            Response response = this.base.sendRequest(URL, Request.METHOD_DELETE);
            return true;
        } catch (NotFound e) {
            throw new ThreadNotFound(threadSlug);
        }
    }


    /**
     * Update Channel Thread
     *
     * @param teamSlug Team Slug
     * @param channelSlug Channel Slug
     * @param threadSlug Thread Slug
     * @param threadSubject Thread Subject
     * @param threadDescription Thread Description
     * @return Thread
     * @throws BaseHttpException
     */
    public Thread updateChannelThread(String teamSlug, String channelSlug, String threadSlug, String threadSubject, String threadDescription) throws BaseHttpException, ThreadNotFound {
        Map<String, String> parameters = new HashMap<>();
        if (!threadSubject.isEmpty()) {
            parameters.put("subject", threadSubject);
        }

        if (!threadDescription.isEmpty()) {
            parameters.put("description", threadDescription);
        }

        String URL = "/teams/".concat(teamSlug).concat("/channels/").concat(channelSlug).concat("/threads/").concat(threadSlug);
        try{
            Response response = this.base.sendRequest(URL, Request.METHOD_PATCH, parameters);
            return (Thread) Base.makeModel(Thread.class, response.getBody());
        }catch (NotFound e){
            throw  new ThreadNotFound(threadSlug);
        }

    }

}
