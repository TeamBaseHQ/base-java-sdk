package com.base.Services;

import com.base.Auth.AccessToken;
import com.base.Base;
import com.base.BaseClient;
import com.base.Exceptions.BaseException;
import junit.framework.TestCase;

public class AbstractBaseTest extends TestCase {
    protected static void getUserAccessToken(Base base) {
        try {
            AccessToken accessToken = base.getUserAccessToken("sharvilshah1996@gmail.com", "abcd1234");
            base.getClient().setAccessToken(accessToken);
        } catch (BaseException e) {
            e.printStackTrace();
        }
    }

    protected static Base getBase() {
        BaseClient baseClient = new BaseClient();
        baseClient.setClientId("1").setClientSecret("eyIzeSButivrkHGc1PAfU4IBclYONeRy73eZvi1b");
        return new Base(baseClient);
    }
}
