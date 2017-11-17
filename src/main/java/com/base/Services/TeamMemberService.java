package com.base.Services;

import com.base.Base;
import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.Http.NotFound;
import com.base.Exceptions.TeamNotFound;
import com.base.Helpers;
import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Models.User;

import java.util.*;

public class TeamMemberService {

    /**
     * {@link Base}
     */
    private Base base;

    /**
     * Construct Instance of Base Class
     *
     * @param base
     */
    public TeamMemberService(Base base) {
        this.base = base;
    }

    /**
     * Get User of Team by Slug of Team
     *
     * @param teamSlug Team of Slug
     * @param user_id  User Id
     * @return User
     * @throws TeamNotFound
     * @throws BaseHttpException
     */
    public User getTeamMember(String teamSlug, String user_id) throws TeamNotFound, BaseHttpException {
        try {
            String URL = "/teams/".concat(teamSlug).concat("/members/").concat(user_id);
            Response response = this.base.sendRequest(URL, Request.METHOD_GET);
            return (User) Base.makeModel(User.class, response.getBody());
        } catch (NotFound e) {
            throw new TeamNotFound(teamSlug);
        }
    }

    /**
     * Show All Members in Team
     *
     * @param teamSlug Team Slug Name
     * @param page     Page number
     * @param limit    Limit Value
     * @return List of Users
     * @throws TeamNotFound Exception
     */
    public List<User> getAllTeamMembers(String teamSlug, int page, int limit) throws TeamNotFound, BaseHttpException {

        ArrayList<String> parameters = new ArrayList<>();

        if (page != 0) {
            parameters.add("page=".concat(Integer.toString(page)));
        }
        if (limit != 0) {
            parameters.add("limit=".concat(Integer.toString(limit)));
        }
        String URL = Helpers.buildUrlWithQuery("/teams/".concat(teamSlug).concat("/members"), parameters);
        try {
            Response response = this.base.sendRequest(URL, Request.METHOD_GET);
            User[] usersArray = (User[]) Base.makeModel(User[].class, response.getBody());
            return new ArrayList<>(Arrays.asList(usersArray));
        } catch (NotFound e) {
            throw new TeamNotFound(teamSlug);
        }
    }

    /**
     * Show All Members in Team
     *
     * @param teamSlug Team Slug Name
     * @return List of Users
     * @throws TeamNotFound
     * @throws BaseHttpException
     */
    public List<User> getAllTeamMembers(String teamSlug) throws TeamNotFound, BaseHttpException {
        return getAllTeamMembers(teamSlug, 0, 0);
    }

    /**
     * Show All Members in Team
     *
     * @param teamSlug Team Slug Name
     * @param page     Page number
     * @return List of Users
     * @throws TeamNotFound
     * @throws BaseHttpException
     */
    public List<User> getAllTeamMembers(String teamSlug, int page) throws TeamNotFound, BaseHttpException {
        return getAllTeamMembers(teamSlug, page, 0);
    }

    /**
     * Delete Team Members by Team Slug Name
     *
     * @param teamSlug Name of Slug
     * @param user_id  Id of User
     * @return True or False
     * @throws BaseHttpException Exception
     * @throws TeamNotFound      Exception
     */
    public boolean deleteTeamMember(String teamSlug, String user_id) throws BaseHttpException, TeamNotFound {
        try {
            String URL = "/teams/".concat(teamSlug).concat("/members/").concat(user_id);
            Response response = this.base.sendRequest(URL, Request.METHOD_DELETE);
            return true;
        } catch (NotFound e) {
            throw new TeamNotFound(teamSlug);
        }
    }

    /**
     * Add Member into Team
     *
     * @param teamSlug Team Slug Name
     * @param user_id  User Id
     * @return Boolean Value True or False
     * @throws BaseHttpException Exception
     * @throws TeamNotFound      Exception
     */
    public boolean addTeamMember(String teamSlug, String user_id) throws BaseHttpException, TeamNotFound {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("user_id", user_id);
        String URL = "/teams/".concat(teamSlug).concat("/members");
        try {
            Response response = this.base.sendRequest(URL, Request.METHOD_POST, parameters);
            return true;
        } catch (NotFound e) {
            throw new TeamNotFound(teamSlug);
        }

    }


}
