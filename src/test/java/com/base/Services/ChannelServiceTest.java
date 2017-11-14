package com.base.Services;

import com.base.Base;
import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.ChannelNotFound;
import com.base.Exceptions.TeamNotFound;
import com.base.MainTest;
import com.base.Models.Channel;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ChannelServiceTest extends MainTest {

    /**
     * {@link Base}
     */
    private static Base base;

    /**
     * User Login and Authentication
     */
    @BeforeClass
    public static void setUp() {
        base = getBase();
        getUserAccessToken(base);
    }

    /**
     * @throws BaseHttpException
     * @throws TeamNotFound
     */
    @Test
    public void createChannel() throws BaseHttpException, TeamNotFound {
        Channel channel = base.channelService().createChannel("twitter-1-2", "Design Channel", "This is Design Channel", "ed5fc7", false);
        assertEquals(channel.getName(), "Design");
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
            assertEquals(actualName, expectName);
        }
    }

    /**
     * @throws ChannelNotFound
     */
    @Test
    public void deleteChannel() throws ChannelNotFound {
        boolean result = base.channelService().deleteChannel("twitter-1-2", "design-1-5");
        assertEquals(true, result);
    }

    /**
     * @throws BaseHttpException
     * @throws ChannelNotFound
     */
    @Test
    public void updateChannel() throws BaseHttpException, ChannelNotFound {

        Channel channel = base.channelService().updateChannel("twitter-1-2", "design-1-5", "Design Channel",
                "This is Design Team", "", true);
        assertEquals(channel.getName(), "Design Channel");
    }

    /**
     * @throws BaseHttpException
     * @throws ChannelNotFound
     */
    @Test
    public void getChannel() throws BaseHttpException, ChannelNotFound {
        Channel channel = base.channelService().getChannel("twitter-1-2", "design-1-5");
        assertEquals(channel.getName(), "Design Channel");
    }
}
