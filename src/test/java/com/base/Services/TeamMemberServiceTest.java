package com.base.Services;

import com.base.AbstractBaseTest;
import com.base.Base;
import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.TeamNotFound;
import com.base.Models.User;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TeamMemberServiceTest extends AbstractBaseTest {

    /**
     * {@link Base}
     */
    private Base base;

    /**
     * User Login and Authentication
     */
    @BeforeClass
    public void setUp() {
        base = getBase();
        getUserAccessToken(base);
    }


    /**
     * Test Case for Get Team Member
     *
     * @throws BaseHttpException
     * @throws TeamNotFound
     */
    @Test
    public void getTeamMember() throws BaseHttpException, TeamNotFound {

        User user = base.teamMemberService().getTeamMember("twitter-1-2", "3");
        assertEquals(user.getName(), "Sharvil");
    }

    /**
     * Test Case for Get All the Members of Team
     *
     * @throws BaseHttpException
     * @throws TeamNotFound
     */
    @Test
    public void getAllTeamMembers() throws BaseHttpException, TeamNotFound {
        List<String> expected = Arrays.asList("Sharvil", "TEMP");
        List<User> Actual = base.teamMemberService().getAllTeamMembers("twitter-1-2");
        for (int i = 0; i < Actual.size(); i++) {
            String actualName = Actual.get(i).getName();
            String expectName = expected.get(i);
            assertEquals(actualName, expectName);
        }

    }

    /**
     * Test Case for Delete Particular Member from team
     *
     * @throws BaseHttpException
     * @throws TeamNotFound
     */
    @Test
    public void deleteTeamMember() throws BaseHttpException, TeamNotFound {
        boolean result = base.teamMemberService().deleteTeamMember("twitter-1-2", "4");
        assertEquals(true, result);

    }

    /**
     * Test Case for Add Member to Team
     *
     * @throws BaseHttpException
     * @throws TeamNotFound
     */
    @Test
    public void addTeamMember() throws BaseHttpException, TeamNotFound {
        boolean result = base.teamMemberService().addTeamMember("dateam", "3");
        assertEquals(true, result);
    }

}
