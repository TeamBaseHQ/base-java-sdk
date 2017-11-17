package com.base;

import com.base.Http.Clients.TestHttpClient;
import com.base.Http.Server.TestHttpServer;
import org.junit.Before;

public abstract class AbstractBaseTest {

    protected Base base;


    /**
     * Get Base instance.
     *
     * @return Base Client Instance.
     */
    public Base getBase() {
        return base;
    }

    /**
     * Bootstrap.
     */
    @Before
    public void setUp() throws Exception {
        this.base = setupBase();
    }

    /**
     * Setup base.
     *
     * @return Base Client
     */
    protected static Base setupBase() {
        TestHttpServer server = AbstractBaseTest.makeServer();
        TestHttpClient httpClient = new TestHttpClient(server);

        BaseClient baseClient = new BaseClient(httpClient);
        baseClient
                .setApiUrl("localhost")
                .setClientId("1")
                .setClientSecret("secret");

        return new Base(baseClient);
    }

    /**
     * Make a Test API Server.
     *
     * @return TestHttpServer Instance.
     */
    protected static TestHttpServer makeServer() {
        RouteMappings routeMappings = new RouteMappings();
        return new TestHttpServer(routeMappings.getRoutes());
    }
}
