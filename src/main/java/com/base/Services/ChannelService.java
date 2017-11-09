package com.base.Services;

import com.base.Base;
import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.ChannelNotFound;
import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Models.Channel;

import java.util.*;

public class ChannelService {

    private Base base;

    public ChannelService(Base base) {
        this.base = base;
    }

    /**
     * Create channel by slug name of team
     *
     * @param teamSlug
     * @param name
     * @param description
     * @param color
     * @param is_private
     * @return Created Channel
     * @throws BaseHttpException
     */

    public Channel createChannel(String teamSlug, String name, String description, String color, String is_private) throws BaseHttpException {
        Map<String, String> parameters = new HashMap<>();

        parameters.put("name", name);
        parameters.put("description", description);
        parameters.put("color", color);
        parameters.put("is_private", is_private);

        Response response = this.base.sendRequest("/teams/".concat(teamSlug).concat("/channels"), Request.METHOD_POST, parameters);
        return (Channel) Base.makeModel(Channel.class, response.getBody());
    }

    /**
     * Get All Channels By Slug
     *
     * @param teamSlug Slug of Team
     * @return List of Channel in slug
     * @throws ChannelNotFound
     */
    public List<Channel> allChannels(String teamSlug) throws ChannelNotFound {
        try {
            Response response = base.sendRequest("/teams/".concat(teamSlug).concat("/channels"), Request.METHOD_GET);
            Channel[] channelArray = (Channel[]) Base.makeModel(Channel[].class, response.getBody());
            return new ArrayList<>(Arrays.asList(channelArray));
        } catch (BaseHttpException e) {
            throw new ChannelNotFound(teamSlug);
        }
    }


    /**
     * Delete Channel by Slug
     *
     * @param teamSlug
     * @param channelSlug
     * @throws ChannelNotFound
     */
    public boolean deleteChannel(String teamSlug, String channelSlug) throws ChannelNotFound {
        try {
            Response response = this.base.sendRequest("/teams/".concat(teamSlug).concat("/channels/").concat(channelSlug), Request.METHOD_DELETE);
            return true;
        } catch (BaseHttpException e) {
            throw new ChannelNotFound(channelSlug);
        }
    }

    /**
     * Update Channel
     *
     * @param teamSlug    Channel teamSlug
     * @param channelSlug Channel channelSlug
     * @param name        Channel name
     * @param description Channel description
     * @param color       Channel color
     * @param is_private  Channel is_private
     * @return Updated Channel
     * @throws BaseHttpException
     */
    public Channel updateChannel(String teamSlug, String channelSlug, String name, String description, String color, String is_private) throws BaseHttpException {
        Map<String, String> parameters = new HashMap<>();
        if (!name.isEmpty()) {
            parameters.put("name", name);
        }
        if (!description.isEmpty()) {
            parameters.put("description", description);
        }
        if (!color.isEmpty()) {
            parameters.put("color", color);
        }
        if (!is_private.isEmpty()) {
            parameters.put("is_private", is_private);
        }

        parameters.put("name", name);
        parameters.put("description", description);
        parameters.put("color", color);
        parameters.put("is_private", is_private);

        String URL = "/teams/".concat(teamSlug).concat("/channels/").concat(channelSlug);
        Response response = this.base.sendRequest(URL, Request.METHOD_PATCH, parameters);
        return (Channel) Base.makeModel(Channel.class, response.getBody());
    }

    public Channel getChannel(String teamSlug,String channelSlug) throws ChannelNotFound {
        try {
            String URL = "/teams/".concat(teamSlug).concat("/channels/").concat(channelSlug);
            Response response = base.sendRequest(URL, Request.METHOD_GET);
           return  (Channel) Base.makeModel(Channel.class, response.getBody());
        } catch (BaseHttpException e) {
            throw new ChannelNotFound(teamSlug);
        }
    }

}
