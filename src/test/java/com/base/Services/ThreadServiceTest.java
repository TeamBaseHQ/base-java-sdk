package com.base.Services;

import com.base.AbstractBaseTest;
import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.ChannelNotFound;
import com.base.Http.Server.Responses.Thread.CreateChannelThreadResponse;
import com.base.Models.Thread;
import org.junit.Assert;
import org.junit.Test;

public class ThreadServiceTest extends AbstractBaseTest {

    /**
     * Test case for Create Team
     *
     * @throws BaseHttpException
     */
    @Test
    public void testTeamCreate() {
        try {
            Thread thread = this.base.threadService().addChannelThread(CreateChannelThreadResponse.VALID_TEAM_SLUG,
                    CreateChannelThreadResponse.VALID_CHANNEL_SLUG,
                    CreateChannelThreadResponse.VALID_SUBJECT,
                    CreateChannelThreadResponse.VALID_DESCRIPTION);
            Assert.assertEquals(thread.getSubject(), CreateChannelThreadResponse.VALID_SUBJECT);
            Assert.assertEquals(thread.getDescription(), CreateChannelThreadResponse.VALID_DESCRIPTION);
            Assert.assertEquals(thread.getId(), CreateChannelThreadResponse.VALID_ID);
        } catch (BaseHttpException | ChannelNotFound e) {
            Assert.fail(e.getMessage());
        }

    }
}
