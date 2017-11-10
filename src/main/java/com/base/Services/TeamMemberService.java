package com.base.Services;

import com.base.Base;
import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.Http.NotFound;
import com.base.Exceptions.TeamNotFound;
import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Models.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TeamMemberService {
    private Base base;

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
    public User showTeamMember(String teamSlug, String user_id) throws TeamNotFound, BaseHttpException {
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
     * @return List of Users
     *
     * @throws TeamNotFound Exception
     */
    public List<User> showListTeamMember(String teamSlug) throws TeamNotFound, BaseHttpException {
        String URL = "/teams/".concat(teamSlug).concat("/members");
        try {
            Response response = this.base.sendRequest(URL, Request.METHOD_GET);
            User[] usersArray = (User[]) Base.makeModel(User[].class, response.getBody());
            return new ArrayList<>(Arrays.asList(usersArray));
        } catch (NotFound e) {
            throw new TeamNotFound(teamSlug);
        }
    }

}
