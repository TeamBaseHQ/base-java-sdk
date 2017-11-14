package com.base.Services;

import com.base.Base;
import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.MessageNotFound;
import com.base.Exceptions.ThreadNotFound;
import com.base.Models.Message;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MessageServiceTest extends AbstractBaseTest {
    /**
     * {@link Base}
     */
    private Base base;

    @BeforeClass
    public void setUp() {
        base = getBase();
        getUserAccessToken(base);
    }


    /**
     * Test case for Create Message
     *
     * @throws ThreadNotFound
     * @throws BaseHttpException
     */
    @Test
    public void createMessage() throws ThreadNotFound, BaseHttpException {
        Message message = base.messageService().createMessage("twitter-1-2", "development", "deploy-to-aws-ecs", "Hello, How are you?", "text");
        assertEquals(message.getContent(), "Hello, How are you?");

    }

    /**
     * Test Case for Get All Messages
     *
     * @throws BaseHttpException
     * @throws ThreadNotFound
     */
    @Test
    public void getAllMessages() throws BaseHttpException, ThreadNotFound {
        List<String> expected = Arrays.asList("Hello, How are you?", "Hello world");
        List<Message> Actual = base.messageService().getAllMessages("twitter-1-2", "development", "deploy-to-aws-ecs");
        for (int i = 0; i < Actual.size(); i++) {
            String actualName = Actual.get(i).getContent();
            String expectName = expected.get(i);
            assertEquals(actualName, expectName);
        }

    }

    /**
     * Test Case for Get Messages
     *
     * @throws BaseHttpException
     * @throws MessageNotFound
     */
    @Test
    public void getMessage() throws BaseHttpException, MessageNotFound {
        Message message = base.messageService().getMessage("twitter-1-2", "development", "deploy-to-aws-ecs", "bEeTV7H2-1-R3zU57MI");
        assertEquals(message.getContent(), "Hello, How are you?");
    }

    /**
     * Test Case for Update Messages
     *
     * @throws BaseHttpException
     * @throws MessageNotFound
     */
    @Test
    public void updateMessage() throws BaseHttpException, MessageNotFound {
        Message message
                = base.messageService().updateMessage("twitter-1-2", "development", "deploy-to-aws-ecs", "bEeTV7H2-1-R3zU57MI", "Hi", "");
        assertEquals(message.getContent(), "Hi");
    }

    /**
     * Test Case for Delete Message
     *
     * @throws BaseHttpException
     * @throws MessageNotFound
     */
    @Test
    public void deleteMessage() throws BaseHttpException, MessageNotFound {
        Boolean result = base.messageService().deleteMessage("twitter-1-2", "development", "deploy-to-aws-ecs", "bEeTV7H2-1-R3zU57MI");
        assertTrue(true);
    }

}
