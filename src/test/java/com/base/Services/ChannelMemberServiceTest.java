package com.base.Services;

import com.base.Base;
import com.base.MainTest;
import com.base.Models.User;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ChannelMemberServiceTest extends MainTest {

    private static Base base;

    @BeforeClass
    public static void setUp() {
        base = getBase();
        getUserAccessToken(base);
    }

    @Test
    public void addChannelMember() throws Exception {
        boolean result = base.channelMemberService().addChannelMember("twitter-1-2", "development", "2");
        assertEquals(true, result);
    }

    @Test
    public void showChannelMember() throws Exception {
        User user = base.channelMemberService().getChannelMember("twitter-1-2", "development", "3");
        assertEquals(user.getName(), "Sharvil");
    }

    @Test
    public void showListChannelMember() throws Exception {
        List<String> expected = Arrays.asList("Sharvil", "TEMP", "Devam Devam", "Kunal Varma");
        List<User> Actual = base.channelMemberService().getAllChannelMembers("twitter-1-2", "development");
        for (int i = 0; i < Actual.size(); i++) {
            String actualName = Actual.get(i).getName();
            String expectName = expected.get(i);
            assertEquals(actualName, expectName);
        }
    }

    @Test
    public void deleteChannelMember() throws Exception {
        boolean result = base.channelMemberService().deleteChannelMember("twitter-1-2", "development", "4");
        assertEquals(true, result);
    }
}
