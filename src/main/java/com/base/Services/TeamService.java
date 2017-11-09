package com.base.Services;

import com.base.Base;
import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.Http.NotFound;
import com.base.Exceptions.TeamNotFound;
import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Models.Team;

import java.util.HashMap;
import java.util.Map;

public class TeamService {

    private Base base;

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
     * @param slug
     * @return Team
     * @throws TeamNotFound
     */
    public Team getTeam(String slug) throws TeamNotFound, BaseHttpException {
        try {
            Response response = this.base.sendRequest("/teams/".concat(slug), Request.METHOD_GET);
            return (Team) Base.makeModel(Team.class, response.getBody());
        } catch (NotFound e) {
            throw new TeamNotFound(slug);
        }
    }






}