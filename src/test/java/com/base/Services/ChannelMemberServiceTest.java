package com.base.Services;

import com.base.AbstractBaseTest;
import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.ChannelNotFound;
import com.base.Http.Server.Responses.ChannelMember.CreateChannelMemberResponse;
import org.junit.Assert;
import org.junit.Test;

public class ChannelMemberServiceTest extends AbstractBaseTest {

    /**
     * Test case for Create Channel
     *
     * @throws BaseHttpException
     */
    @Test
    public void testCreateChannelMember() {
        try {
            boolean result = this.base.channelMemberService()
                            .addChannelMember(CreateChannelMemberResponse.VALID_TEAM_SLUG,
                            CreateChannelMemberResponse.VALID_CHANNEL_SLUG,
                            CreateChannelMemberResponse.VALID_USER_ID);
            Assert.assertEquals(true, result);
        } catch (ChannelNotFound | BaseHttpException e) {
            Assert.fail(e.getMessage());
        }
    }
}
