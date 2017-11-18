package com.base.Services;

import com.base.AbstractBaseTest;
import com.base.Base;
import com.base.Exceptions.BaseHttpException;
import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Http.Server.Responses.Team.CreateTeamResponse;
import com.base.Models.Team;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class TeamServiceTest extends AbstractBaseTest {

    /**
     * Test case for Create Channel
     *
     * @throws BaseHttpException
     */
    @Test
    public void testChannelCreate() throws BaseHttpException {

        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("name", CreateTeamResponse.VALID_NAME);
        parameters.put("description", CreateTeamResponse.VALID_DESCRIPTION);

        Response response = this.base.sendRequest("/teams", Request.METHOD_POST, parameters);
        System.out.println(response.getBody());
        Team team = (Team) Base.makeModel(Team.class, response.getBody());
        Assert.assertEquals(team.getName(), CreateTeamResponse.VALID_NAME);
        Assert.assertEquals(team.getInvitation_code(), CreateTeamResponse.VALID_INVITATION_CODE);
        Assert.assertEquals(team.getDescription(), CreateTeamResponse.VALID_DESCRIPTION);
    }

}
