package com.base.Services;

import com.base.Base;
import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.Http.NotFound;
import com.base.Exceptions.TeamNotFound;
import com.base.Helpers;
import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Models.Media;
import com.base.Models.Message;
import com.base.Models.Team;

import java.io.File;
import java.util.*;

public class TeamService {

    /**
     * {@link Base}
     */
    private Base base;

    /**
     * Construct Instance of Base Class
     *
     * @param base
     */
    public TeamService(Base base) {
        this.base = base;
    }

    /**
     * Create New Team
     *
     * @param name        Team name
     * @param description Team Description
     * @return Created Team
     * @throws BaseHttpException Exception
     */
    public Team createTeam(String name, String description) throws BaseHttpException {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("name", name);
        parameters.put("description", description);

        Response response = this.base.sendRequest("/teams", Request.METHOD_POST, parameters);
        return (Team) Base.makeModel(Team.class, response.getBody());
    }

    /**
     * Get Team By Slug.
     *
     * @param teamSlug
     * @return Team
     * @throws TeamNotFound
     */
    public Team getTeam(String teamSlug) throws TeamNotFound, BaseHttpException {
        try {
            Response response = this.base.sendRequest("/teams/".concat(teamSlug), Request.METHOD_GET);
            return (Team) Base.makeModel(Team.class, response.getBody());
        } catch (NotFound e) {
            throw new TeamNotFound(teamSlug);
        }
    }


    /**
     * Update a Team
     *
     * @param name        Team Name
     * @param description Team Description
     * @param teamSlug    slug name of team
     * @return Updated Team
     * @throws BaseHttpException Exception
     */
    public Team updateTeam(String teamSlug, String name, String description) throws BaseHttpException {
        Map<String, String> parameters = new HashMap<>();


        if (!name.isEmpty()) {
            parameters.put("name", name);
        }

        if (!description.isEmpty()) {
            parameters.put("description", description);
        }

        Response response = this.base.sendRequest("/teams/".concat(teamSlug), Request.METHOD_PATCH, parameters);
        return (Team) Base.makeModel(Team.class, response.getBody());
    }

    /**
     * Delete Team by Slug
     *
     * @param slug Team of slug
     * @throws TeamNotFound
     */
    public boolean deleteTeam(String slug) throws TeamNotFound {

        try {
            Response response = this.base.sendRequest("/teams/".concat(slug), Request.METHOD_DELETE);
            return true;
        } catch (BaseHttpException e) {
            throw new TeamNotFound(slug);
        }
    }

    /**
     * List all the Teams by Pages and Limit
     *
     * @param page  Page number
     * @param limit Limit Value
     * @return List of All the Teams
     */
    public List<Team> getAllTeams(int page, int limit) throws BaseHttpException {

        ArrayList<String> parameters = new ArrayList<>();


        if (page != 0) {
            parameters.add("page=".concat(Integer.toString(page)));
        }
        if (limit != 0) {
            parameters.add("limit=".concat(Integer.toString(limit)));
        }

        String URL = Helpers.buildUrlWithQuery("/teams", parameters);

        Response response = this.base.sendRequest(URL, Request.METHOD_GET);
        Team[] teamArray = (Team[]) Base.makeModel(Team[].class, response.getBody());
        return new ArrayList<>(Arrays.asList(teamArray));
    }

    /**
     * Get all teams by pages
     *
     * @param page Pages
     * @return List of Teams
     */
    public List<Team> getAllTeams(int page) throws BaseHttpException {
        return getAllTeams(page, 0);
    }

    /**
     * Get all teams
     *
     * @return List of Teams
     */
    public List<Team> getAllTeams() throws BaseHttpException {
        return getAllTeams(0, 0);
    }

    /**
     * Get All Stared Message of Team
     *
     * @param teamSlug SLug Name of Team
     * @return List of Messages
     * @throws TeamNotFound      Exception
     * @throws BaseHttpException Exception
     */
    public List<Message> getAllStarredMessages(String teamSlug) throws TeamNotFound, BaseHttpException {
        String URL = "/teams/".concat(teamSlug).concat("/starred-messages");
        try {
            Response response = this.base.sendRequest(URL, Request.METHOD_GET);
            Message[] messagesArray = (Message[]) Base.makeModel(Message[].class, response.getBody());
            return new ArrayList<>(Arrays.asList(messagesArray));
        } catch (NotFound e) {
            throw new TeamNotFound(teamSlug);
        }
    }

    /**
     * Upload Team Picture.
     *
     * @param slug
     * @param picture
     * @return
     * @throws BaseHttpException
     */
    public Media uploadTeamPicture(String slug, File picture) throws BaseHttpException {
        Map<String, String> parameters = new HashMap<>();

        Map<String, File> files = new HashMap<>();
        files.put("file", picture);

        String url = "/teams/".concat(slug).concat("/picture");
        Response response = this.base.sendRequest(url, Request.METHOD_POST, parameters, new HashMap<>(),
                files);
        return (Media) Base.makeModel(Media.class, response.getBody());
    }

}
