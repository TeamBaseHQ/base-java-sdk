package com.base;

import com.base.Auth.AccessToken;
import com.base.Exceptions.BaseException;
import com.base.Http.Clients.TestHttpClient;
import com.base.Http.Server.TestHttpServer;
import junit.framework.TestCase;
import org.junit.BeforeClass;

public abstract class AbstractBaseTest extends TestCase {

    protected static void getUserAccessToken(Base base) {
        try {
            AccessToken accessToken = base.getUserAccessToken("kunalvarma05@gmail.com", "abcd1234");
            base.getClient().setAccessToken(accessToken);
        } catch (BaseException e) {
            e.printStackTrace();
        }
    }

    protected static Base setupBase() {
        TestHttpServer server = AbstractBaseTest.makeServer();
        TestHttpClient httpClient = new TestHttpClient(server);

        BaseClient baseClient = new BaseClient(httpClient);
        baseClient.setClientId("1").setClientSecret("eyIzeSButivrkHGc1PAfU4IBclYONeRy73eZvi1b");
        return new Base(baseClient);
    }

    protected static TestHttpServer makeServer() {
        RouteMappings routeMappings = new RouteMappings();
        return new TestHttpServer(routeMappings.getRoutes());
    }
}
