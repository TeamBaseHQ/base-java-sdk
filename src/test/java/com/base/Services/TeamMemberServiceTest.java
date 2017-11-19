package com.base.Services;

import com.base.AbstractBaseTest;
import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.TeamNotFound;
import com.base.Http.Server.Responses.TeamMember.CreateTeamMemberResponse;
import org.junit.Assert;
import org.junit.Test;

public class TeamMemberServiceTest extends AbstractBaseTest {

    /**
     * Test case for Create Channel
     *
     * @throws BaseHttpException
     */
    @Test
    public void testTeamMemberCreate() throws BaseHttpException, TeamNotFound {
        Boolean result = this.base.teamMemberService().addTeamMember(CreateTeamMemberResponse.VALID_SLUG, CreateTeamMemberResponse.VALID_USER_ID);
        System.out.println(result);
        Assert.assertEquals(result, true);
    }
}
