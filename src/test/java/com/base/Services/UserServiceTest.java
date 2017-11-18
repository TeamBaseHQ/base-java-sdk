package com.base.Services;

import com.base.AbstractBaseTest;
import com.base.Exceptions.UserNotFound;
import com.base.Http.Server.Responses.User.GetUserResponse;
import com.base.Models.User;
import org.junit.Assert;
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
}
