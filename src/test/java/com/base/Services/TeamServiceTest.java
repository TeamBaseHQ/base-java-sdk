package com.base.Services;

import com.base.AbstractBaseTest;
import com.base.Base;
import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.TeamNotFound;
import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Http.Server.Responses.Team.*;
import com.base.Models.Team;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TeamServiceTest extends AbstractBaseTest {

    /**
     * Test case for Create Team
     *
     * @throws BaseHttpException
     */
    @Test
    public void testTeamCreate() throws BaseHttpException {

        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("name", CreateTeamResponse.VALID_NAME);
        parameters.put("description", CreateTeamResponse.VALID_DESCRIPTION);

        Response response = this.base.sendRequest("/teams", Request.METHOD_POST, parameters);
        Team team = (Team) Base.makeModel(Team.class, response.getBody());
        Assert.assertEquals(team.getName(), CreateTeamResponse.VALID_NAME);
        Assert.assertEquals(team.getInvitation_code(), CreateTeamResponse.VALID_INVITATION_CODE);
        Assert.assertEquals(team.getDescription(), CreateTeamResponse.VALID_DESCRIPTION);
    }

    /**
     * @throws BaseHttpException
     * @throws TeamNotFound
     */
    @Test
    public void testGetTeam() throws BaseHttpException, TeamNotFound {
        try {
            Team team = base.teamService().getTeam(GetTeamResponse.VALID_TEAM_SLUG);
            Assert.assertEquals(team.getName(), GetTeamResponse.VALID_NAME);
            Assert.assertEquals(team.getDescription(), GetTeamResponse.VALID_DESCRIPTION);
            Assert.assertEquals(team.getSlug(), GetTeamResponse.VALID_TEAM_SLUG);
            Assert.assertEquals(team.getInvitation_code(), GetTeamResponse.VALID_INVITATION_CODE);
            Assert.assertEquals(team.getId(), GetTeamResponse.VALID_ID);
        } catch (TeamNotFound e) {
            Assert.fail(e.getMessage());
        }
    }


    @Test
    public void testGetAllTeams() throws BaseHttpException, TeamNotFound {

        List<Team> teams = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            teams.add((Team) new Team().setInvitation_code(GetTeamResponse.VALID_INVITATION_CODE)
                    .setName(GetAllTeamsResponse.VALID_NAME.concat(" " + i))
                    .setDescription(GetAllTeamsResponse.VALID_DESCRIPTION)
                    .setSlug(GetAllTeamsResponse.VALID_TEAM_SLUG.concat("-" + i))
                    .setId(GetAllTeamsResponse.VALID_ID));
        }

        List<Team> ActualTeam = base.teamService().getAllTeams();
        for (int i = 0; i < ActualTeam.size(); i++) {
            String actualName = ActualTeam.get(i).getName();
            String expectName = teams.get(i).getName();
            Assert.assertEquals(actualName, expectName);
        }
    }

    @Test
    public void testTeamUpdate() throws BaseHttpException {

        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("name", UpdateTeamResponse.VALID_NAME);
        parameters.put("description", UpdateTeamResponse.VALID_DESCRIPTION);

        Response response = this.base.sendRequest("/teams/".concat(UpdateTeamResponse.VALID_SLUG), Request.METHOD_PATCH, parameters);
        Team team = (Team) Base.makeModel(Team.class, response.getBody());
        Assert.assertEquals(team.getName(), UpdateTeamResponse.VALID_NAME);
        Assert.assertEquals(team.getInvitation_code(), UpdateTeamResponse.VALID_INVITATION_CODE);
        Assert.assertEquals(team.getDescription(), UpdateTeamResponse.VALID_DESCRIPTION);
        Assert.assertEquals(team.getId(), UpdateTeamResponse.VALID_ID);
    }

    public void getDeleteTeam() throws TeamNotFound {
        boolean result = base.teamService().deleteTeam(DeleteTeamResponse.VALID_DELETED_TEAM_SLUG);
        Assert.assertEquals(true, result);
    }
}
