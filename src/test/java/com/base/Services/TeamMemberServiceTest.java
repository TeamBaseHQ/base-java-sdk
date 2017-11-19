package com.base.Services;

import com.base.AbstractBaseTest;
import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.TeamNotFound;
import com.base.Http.Server.Responses.TeamMember.CreateTeamMemberResponse;
import com.base.Http.Server.Responses.TeamMember.GetTeamMemberResponse;
import com.base.Models.User;
import org.junit.Assert;
import org.junit.Test;

public class TeamMemberServiceTest extends AbstractBaseTest {

    /**
     * Test case for Create Channel
     *
     * @throws BaseHttpException
     */
    @Test
    public void testTeamMemberCreate() {
        Boolean result = null;
        try {
            result = this.base.teamMemberService().addTeamMember(CreateTeamMemberResponse.VALID_SLUG, CreateTeamMemberResponse.VALID_USER_ID);
        } catch (BaseHttpException | TeamNotFound e) {
            Assert.fail(e.getMessage());
        }
        System.out.println(result);
        Assert.assertEquals(result, true);
    }

    @Test
    public void testGetTeamMember() {
        try {
            User user = base.teamMemberService().getTeamMember(GetTeamMemberResponse.VALID_TEAM_SLUG, String.valueOf(GetTeamMemberResponse.VALID_USER_ID));
            Assert.assertEquals(user.getName(), GetTeamMemberResponse.VALID_USER_NAME);
            Assert.assertEquals(user.getEmail(), GetTeamMemberResponse.VALID_USER_EMAIL);
            Assert.assertEquals(user.getId(), GetTeamMemberResponse.VALID_USER_ID);
        } catch (TeamNotFound | BaseHttpException e) {
            Assert.fail(e.getMessage());
        }
    }


}
