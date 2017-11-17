package com.base.Services;

import com.base.AbstractBaseTest;
import com.base.Base;
import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.UserNotFound;
import com.base.Http.Server.Responses.User.GetUserResponse;
import com.base.Models.User;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserServiceTest extends AbstractBaseTest {

    /**
     * Test case for Get User
     *
     * @throws UserNotFound
     */
    @Test
    public void testGetUser() throws UserNotFound {
        try {
            User user = base.userService().getUser(String.valueOf(GetUserResponse.VALID_USER_ID));
            Assert.assertEquals(user.getName(), GetUserResponse.USER_NAME);
            Assert.assertEquals(user.getEmail(), GetUserResponse.USER_EMAIL);
        } catch (UserNotFound e) {
            Assert.fail(e.getMessage());
        }
    }

    /**
     * Test case for Get User that throws UserNotFound exception.
     *
     * @throws UserNotFound
     */
    @Test(expected = UserNotFound.class)
    public void testGetUserThrowsNotFound() throws UserNotFound {
        User user = base.userService().getUser("20000");
    }

    /**
     * Test Case for Get Current Logged in User
     *
     * @throws UserNotFound
     */
    @Test
    public void getCurrentUser() throws UserNotFound {
        User user = base.userService().getCurrentUser();
        Assert.assertEquals(user.getName(), "Sharvil");
    }

    /**
     * Test case for Create User
     *
     * @throws BaseHttpException
     */
    @Test
    public void createUser() throws BaseHttpException {
        User user = base.userService().createUser("Sharvil", "sharvilshah1996@gmail.com", "abcd1234");
        Assert.assertEquals(user.getName(), "Sharvil");
    }

    /**
     * Test Case for Update User
     *
     * @throws BaseHttpException
     */
    @Test
    public void updateUser() throws BaseHttpException {
        User user = base.userService().updateUser("Sharvil Shah", "ashim36@gmail.com", "");
        Assert.assertEquals(user.getName(), "Sharvil Shah");
    }
}
