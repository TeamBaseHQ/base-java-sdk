package com.base.Services;


import com.base.Base;
import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.TeamNotFound;
import com.base.Models.Team;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TeamServiceTest extends AbstractBaseTest {

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
     * Test Case for Create Team
     *
     * @throws BaseHttpException
     */
    @Test
    public void createTeam() throws BaseHttpException {
        Team team = base.teamService().createTeam("Twitter", "Twitter Team");
        assertEquals(team.getName(), "Twitter Team");
    }

    /**
     * Test Case for Get Team
     *
     * @throws BaseHttpException
     * @throws TeamNotFound
     */
    @Test
    public void getTeam() throws BaseHttpException, TeamNotFound {
        Team team = base.teamService().getTeam("twitter-1-2");
        assertEquals(team.getName(), "Twitter");
    }


    /**
     * Test Case for Update Team
     *
     * @throws BaseHttpException
     */
    @Test
    public void updateTeam() throws BaseHttpException {

        Team team = base.teamService().updateTeam("da", "Myteam", "dateam");
        assertEquals(team.getSlug(), "dateam1");

    }

    /**
     * Test Case for Delete Team
     *
     * @throws TeamNotFound
     */
    @Test
    public void deleteTeam() throws TeamNotFound {
        boolean result = base.teamService().deleteTeam("dateam");
    }

    /**
     * Test case for
     *
     * @throws BaseHttpException
     */
    @Test
    public void getAllTeams() throws BaseHttpException {
        List<String> expected = Arrays.asList("Twitter", "Amazon");
        List<Team> Actual = base.teamService().getAllTeams(1);
        for (int i = 0; i < Actual.size(); i++) {
            String actualName = Actual.get(i).getName();
            String expectName = expected.get(i);
            assertEquals(actualName, expectName);
        }
    }
}
