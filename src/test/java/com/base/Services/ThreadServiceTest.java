package com.base.Services;

import com.base.AbstractBaseTest;
import com.base.Base;
import com.base.Exceptions.BaseHttpException;
import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Http.Server.Responses.Thread.CreateChannelThreadResponse;
import com.base.Models.Thread;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class ThreadServiceTest extends AbstractBaseTest {

    /**
     * Test case for Create Team
     *
     * @throws BaseHttpException
     */
    @Test
    public void testTeamCreate() {
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("subject", CreateChannelThreadResponse.VALID_SUBJECT);
        parameters.put("description", CreateChannelThreadResponse.VALID_DESCRIPTION);
        String URL = "/teams/".concat(CreateChannelThreadResponse.VALID_TEAM_SLUG)
                .concat("/channels/")
                .concat(CreateChannelThreadResponse.VALID_CHANNEL_SLUG)
                .concat("/threads");

        try {
            Response response = this.base.sendRequest(URL, Request.METHOD_POST, parameters);
            Thread thread = (Thread) Base.makeModel(Thread.class, response.getBody());
            Assert.assertEquals(thread.getSubject(), CreateChannelThreadResponse.VALID_SUBJECT);
            Assert.assertEquals(thread.getDescription(), CreateChannelThreadResponse.VALID_DESCRIPTION);
            Assert.assertEquals(thread.getId(), CreateChannelThreadResponse.VALID_ID);
        } catch (BaseHttpException e) {
            Assert.fail(e.getMessage());
        }

    }
}
