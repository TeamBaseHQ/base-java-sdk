package com.base.Services;

import com.base.AbstractBaseTest;
import com.base.Base;
import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.ChannelNotFound;
import com.base.Exceptions.TeamNotFound;
import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Http.Server.Responses.Channel.CreateChannelResponse;
import com.base.Http.Server.Responses.Channel.GetChannelResponse;
import com.base.Models.Channel;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ChannelServiceTest extends AbstractBaseTest {

    /**
     * Test case for Create Channel
     *
     * @throws BaseHttpException
     */
    @Test
    public void testChannelCreate() throws BaseHttpException {

        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("name", CreateChannelResponse.VALID_NAME);
        parameters.put("description", CreateChannelResponse.VALID_DESCRIPTION);
        parameters.put("color", CreateChannelResponse.VALID_COLOR);
        parameters.put("is_private", CreateChannelResponse.VALID_STATUS);

        Response response = this.base.sendRequest("/teams/".concat(CreateChannelResponse.VALID_TEAM_SLUG).concat("/channels"), Request.METHOD_POST, parameters);
        System.out.println(response.getBody());
        Channel channel = (Channel) Base.makeModel(Channel.class, response.getBody());
        Assert.assertEquals(channel.getName(), CreateChannelResponse.VALID_NAME);
        Assert.assertEquals(channel.getSlug(), CreateChannelResponse.VALID_CHANNEL_SLUG);
        Assert.assertEquals(channel.getDescription(), CreateChannelResponse.VALID_DESCRIPTION);
        Assert.assertEquals(channel.getColor(), CreateChannelResponse.VALID_COLOR);
        Assert.assertEquals(channel.getIs_private(), CreateChannelResponse.VALID_STATUS);
    }


    /**
     * @throws BaseHttpException
     * @throws TeamNotFound
     */
    @Test
    public void getAllChannels() throws BaseHttpException, TeamNotFound {

        List<String> expectedChannel = Arrays.asList("Development", "design channel", "design channel", "design channel", "design channel");
        List<Channel> ActualChannel = base.channelService().getAllChannels("twitter-1-2");
        for (int i = 0; i < ActualChannel.size(); i++) {
            String actualName = ActualChannel.get(i).getName();
            String expectName = expectedChannel.get(i);
            Assert.assertEquals(actualName, expectName);
        }
    }

    /**
     * @throws ChannelNotFound
     */
    @Test
    public void deleteChannel() throws ChannelNotFound {
        boolean result = base.channelService().deleteChannel("twitter-1-2", "design-1-5");
        Assert.assertEquals(true, result);
    }

    /**
     * @throws BaseHttpException
     * @throws ChannelNotFound
     */
    @Test
    public void updateChannel() throws BaseHttpException, ChannelNotFound {

        Channel channel = base.channelService().updateChannel("twitter-1-2", "design-1-5", "Design Channel",
                "This is Design Team", "", true);
        Assert.assertEquals(channel.getName(), "Design Channel");
    }

    /**
     * @throws BaseHttpException
     * @throws ChannelNotFound
     */
    @Test
    public void testGetChannel() throws BaseHttpException, ChannelNotFound {
        try {
            Channel channel = base.channelService().getChannel(GetChannelResponse.VALID_TEAM_SLUG, GetChannelResponse.VALID_CHANNEL_SLUG);
            Assert.assertEquals(channel.getName(), GetChannelResponse.VALID_NAME);
            Assert.assertEquals(channel.getDescription(), GetChannelResponse.VALID_DESCRIPTION);
            Assert.assertEquals(channel.getColor(), GetChannelResponse.VALID_COLOR);
            Assert.assertEquals(channel.getSlug(), GetChannelResponse.VALID_CHANNEL_SLUG);
            Assert.assertEquals(channel.getIs_private(), GetChannelResponse.VALID_STATUS);
        } catch (ChannelNotFound e) {
            Assert.fail(e.getMessage());
        }
    }
}
