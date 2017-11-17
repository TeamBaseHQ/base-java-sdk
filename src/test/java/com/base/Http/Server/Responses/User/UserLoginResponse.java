package com.base.Http.Server.Responses.User;

import com.base.Auth.AccessToken;
import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Http.Server.Responses.BaseResponse;
import com.base.Http.Server.Responses.ServerResponseInterface;
import com.base.Models.User;

public class UserLoginResponse extends BaseResponse {

    public static String USER_NAME = "John Doe";

    public static String VALID_EMAIL = "john@example.com";
    public static String VALID_PASSWORD = "abcd1234";

    public static String INVALID_EMAIL = "jon@example.com";
    public static String INVALID_PASSWORD = "abcd123";

    public static String VALID_ACCESS_TOKEN = "valid_token_abcd_1234";
    public static String INVALID_ACCESS_TOKEN = "invalid_token_abcd_1234";

    @Override
    public Response getResponse(Request request, Response response) {
        // User Credentials are valid.
        if (this.credentialsAreValid(request)) {
            // Success Response
            return response.setStatusCode(200)
                    .setBody(generateResponseBody(getAccessToken()));
        }

        return response.setStatusCode(401).setBody("{'message': 'Unauthenticated.'}");
    }

    /**
     * User Credentials are Valid.
     *
     * @param request Request.
     * @return Validation Result.
     */
    private boolean credentialsAreValid(Request request) {
        String email = request.getParameters().getOrDefault("email", "");
        String password = request.getParameters().getOrDefault("password", "");

        return email.equals(VALID_EMAIL) && password.equals(VALID_PASSWORD);
    }

    /**
     * Get com.base.Auth.AccessToken.
     *
     * @return com.base.Auth.AccessToken.
     */
    public AccessToken getAccessToken() {
        return (new AccessToken(VALID_ACCESS_TOKEN));
    }
}
