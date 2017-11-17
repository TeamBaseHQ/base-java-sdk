package com.base.Services;

import com.base.AbstractBaseTest;
import com.base.Base;
import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.ChannelNotFound;
import com.base.Models.User;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ChannelMemberServiceTest extends AbstractBaseTest {

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
     * @throws BaseHttpException
     * @throws ChannelNotFound
     */
    @Test
    public void addChannelMember() throws BaseHttpException, ChannelNotFound {
        boolean result = base.channelMemberService().addChannelMember("twitter-1-2", "development", "2");
        assertEquals(true, result);
    }

    /**
     * @throws BaseHttpException
     * @throws ChannelNotFound
     */
    @Test
    public void getChannelMember() throws BaseHttpException, ChannelNotFound {
        User user = base.channelMemberService().getChannelMember("twitter-1-2", "development", "3");
        assertEquals(user.getName(), "Sharvil");
    }

    /**
     * @throws BaseHttpException
     * @throws ChannelNotFound
     */
    @Test
    public void showListChannelMember() throws BaseHttpException, ChannelNotFound {
        List<String> expected = Arrays.asList("Sharvil", "TEMP", "Devam Devam", "Kunal Varma");
        List<User> Actual = base.channelMemberService().getAllChannelMembers("twitter-1-2", "development");
        for (int i = 0; i < Actual.size(); i++) {
            String actualName = Actual.get(i).getName();
            String expectName = expected.get(i);
            assertEquals(actualName, expectName);
        }
    }

    /**
     * @throws BaseHttpException
     * @throws ChannelNotFound
     */
    @Test
    public void deleteChannelMember() throws BaseHttpException, ChannelNotFound {
        boolean result = base.channelMemberService().deleteChannelMember("twitter-1-2", "development", "4");
        assertEquals(true, result);
    }
}
