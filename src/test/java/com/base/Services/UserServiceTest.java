package com.base.Services;

import com.base.Base;
import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.UserNotFound;
import com.base.MainTest;
import com.base.Models.User;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserServiceTest extends MainTest {

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
     * Test case for Get User
     *
     * @throws UserNotFound
     */
    @Test
    public void getUser() throws UserNotFound {
        User user = base.userService().getUser("2");
        assertEquals(user.getName(), "Kunal Varma");
    }

    /**
     * Test Case for Get Current Logged in User
     *
     * @throws UserNotFound
     */
    @Test
    public void getCurrentUser() throws UserNotFound {
        User user = base.userService().getCurrentUser();
        assertEquals(user.getName(), "Sharvil");
    }

    /**
     * Test case for Create User
     *
     * @throws BaseHttpException
     */
    @Test
    public void createUser() throws BaseHttpException {
        User user = base.userService().createUser("Sharvil", "sharvilshah1996@gmail.com", "abcd1234");
        assertEquals(user.getName(), "Sharvil");
    }

    /**
     * Test Case for Update User
     *
     * @throws BaseHttpException
     */
    @Test
    public void updateUser() throws BaseHttpException {
        User user = base.userService().updateUser("Sharvil Shah", "ashim36@gmail.com", "");
        assertEquals(user.getName(), "Sharvil Shah");
    }
}
