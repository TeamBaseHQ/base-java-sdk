package com.base.Services;

import com.base.Base;
import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.Http.NotFound;
import com.base.Exceptions.TeamNotFound;
import com.base.Helpers;
import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Models.Invitation;

import java.util.*;

public class InvitationService {
    /**
     * {@link Base}
     */
    private Base base;

    /**
     * Construct Instance of Base Class
     *
     * @param base
     */
    public InvitationService(Base base) {
        this.base = base;
    }


    /**
     * Create Invitation Link for Team
     *
     * @param teamSlug Team Slug Name
     * @param email    User's Invitation
     * @param message  Invitation Message
     * @return
     * @throws BaseHttpException
     * @throws TeamNotFound
     */
    public boolean sendInvitation(String teamSlug, String email, String message) throws BaseHttpException, TeamNotFound {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", email);
        parameters.put("message", message);

        try {
            Response response = this.base
                    .sendRequest("/teams/".concat(teamSlug).concat("/invitations"), Request.METHOD_POST, parameters);
            return true;
        } catch (NotFound e) {
            throw new TeamNotFound(teamSlug);
        }
    }


    /**
     * List of Invitation of Team
     *
     * @param teamSlug Slug of Team
     * @param page     Page number
     * @param limit    Limit Value
     * @return List of Teams
     * @throws TeamNotFound      Exception
     * @throws BaseHttpException Exception
     */
    public List<Invitation> getAllInvitations(String teamSlug, int page, int limit) throws TeamNotFound, BaseHttpException {
        ArrayList<String> parameters = new ArrayList<>();

        if (page != 0) {
            parameters.add("page=".concat(Integer.toString(page)));
        }
        if (limit != 0) {
            parameters.add("limit=".concat(Integer.toString(limit)));
        }

        String URL = Helpers.buildUrlWithQuery("/teams/".concat(teamSlug).concat("/invitations"), parameters);

        try {
            Response response = base.sendRequest(URL, Request.METHOD_GET);
            Invitation[] invitationsArray = (Invitation[]) Base.makeModel(Invitation[].class, response.getBody());
            return new ArrayList<>(Arrays.asList(invitationsArray));
        } catch (NotFound e) {
            throw new TeamNotFound(teamSlug);
        }
    }


    /**
     * List of Invitation of Team
     *
     * @param teamSlug Slug of Team
     * @param page     Page number
     * @return List of Teams
     * @throws TeamNotFound      Exception
     * @throws BaseHttpException Exception
     */
    public List<Invitation> getAllInvitations(String teamSlug, int page) throws TeamNotFound, BaseHttpException {
        return getAllInvitations(teamSlug, page, 0);
    }

    /**
     * List of Invitation of Team
     *
     * @param teamSlug Slug of Team
     * @return List of Teams
     * @throws TeamNotFound      Exception
     * @throws BaseHttpException Exception
     */
    public List<Invitation> getAllInvitations(String teamSlug) throws TeamNotFound, BaseHttpException {
        return getAllInvitations(teamSlug, 0, 0);
    }

    /**
     * Cancel Invitation Link for Team
     *
     * @param teamSlug Team Slug Name
     * @return
     * @throws BaseHttpException
     * @throws TeamNotFound
     */
    public boolean cancelInvitation(String teamSlug, String id) throws BaseHttpException, TeamNotFound {

        String URL = "/teams/".concat(teamSlug).concat("/invitations/").concat(id);
        try {
            Response response = this.base.sendRequest(URL, Request.METHOD_DELETE);
            return true;
        } catch (NotFound e) {
            throw new TeamNotFound(teamSlug);
        }
    }

}
