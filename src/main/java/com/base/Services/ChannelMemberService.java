package com.base.Services;

import com.base.Base;
import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.ChannelNotFound;
import com.base.Exceptions.Http.NotFound;
import com.base.Helpers;
import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Models.User;

import java.util.*;

public class ChannelMemberService {

    /**
     * {@link Base}
     */
    private Base base;

    /**
     * Construct Instance of Base Class
     *
     * @param base
     */
    public ChannelMemberService(Base base) {
        this.base = base;
    }

    /**
     * Add Member to Channel
     *
     * @param teamSlug    Team Slug
     * @param channelSlug Channel Slug
     * @param user_id     User Id
     * @return Boolean True or False
     * @throws BaseHttpException Exception
     * @throws ChannelNotFound   Exception
     */
    public boolean addChannelMember(String teamSlug, String channelSlug, String user_id) throws BaseHttpException, ChannelNotFound {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("user_id", user_id);
        String URL = "/teams/".concat(teamSlug).concat("/channels/").concat(channelSlug).concat("/members");
        try {
            Response response = this.base.sendRequest(URL, Request.METHOD_POST, parameters);
            return true;
        } catch (NotFound e) {
            throw new ChannelNotFound(channelSlug);
        }
    }

    /**
     * Show Member By Channel
     *
     * @param teamSlug    Team Slug
     * @param channelSlug Channel Slug
     * @param user_id     User Id
     * @return User
     * @throws ChannelNotFound   Exception
     * @throws BaseHttpException Exception
     */
    public User getChannelMember(String teamSlug, String channelSlug, String user_id) throws ChannelNotFound, BaseHttpException {
        try {
            String URL = "/teams/".concat(teamSlug).concat("/channels/").concat(channelSlug).concat("/members/").concat(user_id);
            Response response = this.base.sendRequest(URL, Request.METHOD_GET);
            return (User) Base.makeModel(User.class, response.getBody());
        } catch (NotFound e) {
            throw new ChannelNotFound(channelSlug);
        }
    }

    /**
     * Show All Users in Channel
     *
     * @param teamSlug    Slug Name
     * @param channelSlug Channel Slug
     * @param page        Page number
     * @param limit       Limit Value
     * @return List of Users
     * @throws ChannelNotFound   Exception
     * @throws BaseHttpException Exception
     */
    public List<User> getAllChannelMembers(String teamSlug, String channelSlug, int page, int limit) throws ChannelNotFound, BaseHttpException {

        ArrayList<String> parameters = new ArrayList<>();

        if (page != 0) {
            parameters.add("page=".concat(Integer.toString(page)));
        }
        if (limit != 0) {
            parameters.add("limit=".concat(Integer.toString(limit)));
        }

        try {
            String URL = Helpers.buildUrlWithQuery("/teams/".concat(teamSlug).concat("/channels/").concat(channelSlug).concat("/members"), parameters);
            Response response = this.base.sendRequest(URL, Request.METHOD_GET);
            User[] usersArray = (User[]) Base.makeModel(User[].class, response.getBody());
            return new ArrayList<>(Arrays.asList(usersArray));
        } catch (NotFound e) {
            throw new ChannelNotFound(channelSlug);
        }
    }

    /**
     * Show All Users in Channel
     *
     * @param teamSlug    Slug Name
     * @param channelSlug Channel Slug
     * @param page        Page number
     * @return List of Users
     * @throws ChannelNotFound   Exception
     * @throws BaseHttpException Exception
     */
    public List<User> getAllChannelMembers(String teamSlug, String channelSlug, int page) throws ChannelNotFound, BaseHttpException {
        return getAllChannelMembers(teamSlug, channelSlug, page, 0);
    }

    /**
     * Show All Users in Channel
     *
     * @param teamSlug    Slug Name
     * @param channelSlug Channel Slug
     * @return List of Users
     * @throws ChannelNotFound   Exception
     * @throws BaseHttpException Exception
     */
    public List<User> getAllChannelMembers(String teamSlug, String channelSlug) throws ChannelNotFound, BaseHttpException {
        return getAllChannelMembers(teamSlug, channelSlug, 0, 0);
    }

    /**
     * Delete Channel Member
     *
     * @param teamSlug    Team Slug
     * @param channelSlug Channel Slug
     * @param user_id     User Id
     * @throws BaseHttpException Exception
     * @throws ChannelNotFound   Exception
     */
    public boolean deleteChannelMember(String teamSlug, String channelSlug, String user_id) throws BaseHttpException, ChannelNotFound {
        String URL = "/teams/".concat(teamSlug).concat("/channels/").concat(channelSlug).concat("/members/").concat(user_id);
        try {
            Response response = this.base.sendRequest(URL, Request.METHOD_DELETE);
            return true;
        } catch (NotFound e) {
            throw new ChannelNotFound(channelSlug);
        }
    }
}
