package com.base.Services;

import com.base.AbstractBaseTest;
import com.base.Base;
import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.UserNotFound;
import com.base.Models.User;
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
    public void getUser() throws UserNotFound {
        User user = base.userService().getUser("2");
        Assert.assertEquals(user.getName(), "Kunal Varma");
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
