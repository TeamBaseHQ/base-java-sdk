package com.base.Services;

import com.base.Base;
import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.ChannelNotFound;
import com.base.Exceptions.TeamNotFound;
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
     * @param slug
     * @param name
     * @param description
     * @param color
     * @param is_private
     * @return Created Channel
     * @throws BaseHttpException
     */

    public Channel createChannel(String slug, String name, String description, String color, String is_private) throws BaseHttpException {
        Map<String, String> parameters = new HashMap<>();

        parameters.put("name", name);
        parameters.put("description", description);
        parameters.put("color", color);
        parameters.put("is_private", is_private);

        Response response = this.base.sendRequest("/teams/".concat(slug).concat("/channels"), Request.METHOD_POST, parameters);
        return (Channel) Base.makeModel(Channel.class, response.getBody());
    }

   

}
