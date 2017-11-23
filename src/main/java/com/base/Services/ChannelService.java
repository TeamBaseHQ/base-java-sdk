package com.base.Services;

import com.base.Base;
import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.ChannelNotFound;
import com.base.Exceptions.Http.NotFound;
import com.base.Exceptions.TeamNotFound;
import com.base.Helpers;
import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Models.Channel;
import com.base.Models.Media;

import java.io.File;
import java.util.*;

public class ChannelService {

    /**
     * {@link Base}
     */
    private Base base;

    /**
     * Construct Instance of Base Class
     *
     * @param base
     */
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
    public Channel createChannel(String teamSlug, String name, String description, String color, boolean is_private) throws BaseHttpException, TeamNotFound {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("name", name);
        parameters.put("description", description);
        parameters.put("color", color);
        parameters.put("is_private", (is_private ? "1" : "0"));
        try {
            Response response = this.base.sendRequest("/teams/".concat(teamSlug).concat("/channels"), Request.METHOD_POST, parameters);
            return (Channel) Base.makeModel(Channel.class, response.getBody());
        } catch (NotFound e) {
            throw new TeamNotFound(teamSlug);
        }
    }

    /**
     * Get All Channels By Slug
     *
     * @param teamSlug Slug of Team
     * @param page     Page number
     * @param limit    Limit Value
     * @return List of Channel in slug
     * @throws TeamNotFound      Exception
     * @throws BaseHttpException Exception
     */
    public List<Channel> getAllChannels(String teamSlug, int page, int limit) throws TeamNotFound, BaseHttpException {
        ArrayList<String> parameters = new ArrayList<>();

        if (page != 0) {
            parameters.add("page=".concat(Integer.toString(page)));
        }
        if (limit != 0) {
            parameters.add("limit=".concat(Integer.toString(limit)));
        }

        String URL = Helpers.buildUrlWithQuery("/teams/".concat(teamSlug).concat("/channels"), parameters);

        try {
            Response response = base.sendRequest(URL, Request.METHOD_GET);
            Channel[] channelArray = (Channel[]) Base.makeModel(Channel[].class, response.getBody());
            return new ArrayList<>(Arrays.asList(channelArray));
        } catch (NotFound e) {
            throw new TeamNotFound(teamSlug);
        }
    }

    /**
     * Get All Channels By Slug
     *
     * @param teamSlug Slug of Team
     * @param page     Page number
     * @return List of Channel in slug
     * @throws TeamNotFound      Exception
     * @throws BaseHttpException Exception
     */
    public List<Channel> getAllChannels(String teamSlug, int page) throws TeamNotFound, BaseHttpException {
        return getAllChannels(teamSlug, page, 0);
    }

    /**
     * Get All Channels By Slug
     *
     * @param teamSlug Slug of Team
     * @return List of Channel in slug
     * @throws TeamNotFound      Exception
     * @throws BaseHttpException Exception
     */
    public List<Channel> getAllChannels(String teamSlug) throws TeamNotFound, BaseHttpException {
        return getAllChannels(teamSlug, 0, 0);
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
    public Channel updateChannel(String teamSlug, String channelSlug, String name, String description, String color, boolean is_private) throws BaseHttpException, ChannelNotFound {
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

        parameters.put("is_private", (is_private ? "1" : "0"));

        String URL = "/teams/".concat(teamSlug).concat("/channels/").concat(channelSlug);

        try {
            Response response = this.base.sendRequest(URL, Request.METHOD_PATCH, parameters);
            return (Channel) Base.makeModel(Channel.class, response.getBody());
        } catch (NotFound e) {
            throw new ChannelNotFound(channelSlug);
        }
    }

    /**
     * Get Channel By Name
     *
     * @param teamSlug
     * @param channelSlug
     * @return Channel
     * @throws ChannelNotFound
     * @throws BaseHttpException
     */
    public Channel getChannel(String teamSlug, String channelSlug) throws ChannelNotFound, BaseHttpException {
        try {
            String URL = "/teams/".concat(teamSlug).concat("/channels/").concat(channelSlug);
            Response response = base.sendRequest(URL, Request.METHOD_GET);
            return (Channel) Base.makeModel(Channel.class, response.getBody());
        } catch (NotFound e) {
            throw new ChannelNotFound(teamSlug);
        }
    }

    public Media[] uploadMedia(String teamSlug, String channelSlug, File[] pictures) throws ChannelNotFound {
        Map<String, String> parameters = new HashMap<>();

        Map<String, File> files = new HashMap<>();
        for (File picture : pictures) {
            files.put("file", picture);
        }
        Response response = null;
        try {
            String URL = "/teams/".concat(teamSlug).concat("/channels/").concat(channelSlug).concat("/media");
            response = this.base.sendRequest(URL, Request.METHOD_POST, parameters, new HashMap<>(),
                    files);
        } catch (NotFound e) {
            throw new ChannelNotFound(teamSlug);
        } catch (BaseHttpException e) {
            e.printStackTrace();
        }
        return (Media[]) Base.makeModel(Media[].class, response.getBody());
    }

}
