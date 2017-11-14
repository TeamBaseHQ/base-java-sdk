package com.base.Services;

import com.base.Base;
import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.ChannelNotFound;
import com.base.Exceptions.ThreadNotFound;
import com.base.MainTest;
import com.base.Models.Thread;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ThreadServiceTest extends MainTest {
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
     * Test case for Channel Thread
     *
     * @throws BaseHttpException
     * @throws ChannelNotFound
     */
    @Test
    public void addChannelThread() throws BaseHttpException, ChannelNotFound {
        Thread thread = base.threadService().addChannelThread("twitter-1-2", "development", "Hello", "Hello World");
        assertEquals(thread.getSubject(), "Hello");
    }

    /**
     * Test case for All Channel Thread
     *
     * @throws BaseHttpException
     * @throws ChannelNotFound
     */
    @Test
    public void getAllChannelThreads() throws BaseHttpException, ChannelNotFound {
        List<String> expected = Arrays.asList("deploy-to-aws-ecs", "deploy-to-aws-ecs-2");
        List<Thread> Actual = base.threadService().getAllChannelThreads("twitter-1-2", "development");
        for (int i = 0; i < Actual.size(); i++) {
            String actualName = Actual.get(i).getSubject();
            String expectName = expected.get(i);
            assertEquals(actualName, expectName);
        }
    }

    /**
     * Test case for Get Channel Thread
     *
     * @throws ThreadNotFound
     * @throws BaseHttpException
     */
    @Test
    public void getChannelThread() throws ThreadNotFound, BaseHttpException {
        Thread thread = base.threadService().getChannelThread("twitter-1-2", "development", "hello");
        assertEquals(thread.getDescription(), "Hello World");
    }

    /**
     * Test case for Delete Channel Thread
     *
     * @throws ThreadNotFound
     * @throws BaseHttpException
     */
    @Test
    public void deleteChannelThread() throws ThreadNotFound, BaseHttpException {
        boolean result = base.threadService().deleteChannelThread("twitter-1-2", "development", "hello-1");
        assertEquals(result, true);
    }

    /**
     * Test Case for Update Channel Thread
     *
     * @throws BaseHttpException
     * @throws ThreadNotFound
     */
    @Test
    public void updateChannelThread() throws BaseHttpException, ThreadNotFound {
        Thread thread = base.threadService().updateChannelThread("twitter-1-2", "development", "deploy-to-aws-ecs", "Hello", "");
        assertEquals(thread.getSubject(), "Hello");
    }

}