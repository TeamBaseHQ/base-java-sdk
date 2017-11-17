package com.base;

import com.base.Auth.AccessToken;
import com.base.Exceptions.BaseHttpException;
import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Http.Server.Responses.User.UserLoginResponse;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class BaseTest extends AbstractBaseTest {

    /**
     * Test case for getUserAccessToken.
     */
    @Test
    public void getUserAccessToken() throws BaseHttpException {
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("email", UserLoginResponse.VALID_EMAIL);
        parameters.put("password", UserLoginResponse.VALID_PASSWORD);

        Response response = this.base.sendRequest("/users/login", Request.METHOD_POST, parameters);
        System.out.println(response.getBody());
        AccessToken accessToken = (AccessToken) Base.makeModel(AccessToken.class, response.getBody());
        Assert.assertEquals(accessToken.getAccessToken(), UserLoginResponse.VALID_ACCESS_TOKEN);
    }

}
