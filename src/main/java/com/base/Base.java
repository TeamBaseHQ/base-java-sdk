package com.base;

import com.base.Auth.AccessToken;
import com.base.Exceptions.BaseException;
import com.base.Exceptions.BaseHttpException;
import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Models.ResponseModel;
import com.base.Services.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public final class Base {

    private BaseClient client;

    private UserService userService;

    public Base() {
        this.client = new BaseClient();
        this.bootstrapServices();
    }

    public Base(String accessToken) {
        this();
        this.getClient()
                .setAccessToken(new AccessToken(accessToken));
    }

    public Base(String clientId, String clientSecret) {
        this();
        this.getClient()
                .setClientId(clientId)
                .setClientSecret(clientSecret);
    }

    public Base(BaseClient client) {
        this();
        this.client = client;
    }

    public BaseClient getClient() {
        return client;
    }

    public Base setClient(BaseClient client) {
        this.client = client;
        return this;
    }

    /**
     * Make Model.
     *
     * @param model    Model Type.
     * @param jsonData JSON Data.
     * @return Model Object.
     */
    public static Object makeModel(Type model, String jsonData) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        ResponseModel response = gson.fromJson(jsonData, ResponseModel.class);
        Object data = response.getData();
        String jData = gson.toJson(data);
        return gson.fromJson(jData, model);
    }

    public Response sendRequest(String endpoint, String method)
            throws BaseHttpException {
        return this.sendRequest(endpoint, method, new HashMap<>());
    }

    public Response sendRequest(String endpoint, String method, Map<String, String> parameters)
            throws BaseHttpException {
        return this.sendRequest(endpoint, method, parameters, new HashMap<>());
    }

    public Response sendRequest(String endpoint, String method, Map<String, String> parameters, Map<String, String>
            headers)
            throws BaseHttpException {
        return this.sendRequest(endpoint, method, parameters, headers, new HashMap<>());
    }

    public Response sendRequest(String endpoint, String method, Map<String, String> parameters, Map<String, String>
            headers, Map<String, File> files)
            throws BaseHttpException {
        return this.sendRequest(endpoint, method, parameters, headers, files, null, null);
    }


    public Response sendRequest(String endpoint, String method, Map<String, String> parameters, Map<String, String>
            headers, Map<String, File> files, AccessToken accessToken)
            throws BaseHttpException {
        return this.sendRequest(endpoint, method, parameters, headers, files, accessToken, null);
    }

    public Response sendRequest(String endpoint, String method, Map<String, String> parameters, Map<String, String>
            headers, Map<String, File> files, AccessToken accessToken, Response response) throws BaseHttpException {
        Request request = new Request(endpoint, method);
        request.setHeaders(headers)
                .setFiles(files)
                .setParameters(parameters)
                .setAccessToken(accessToken);

        return this.getClient().sendRequest(request, response);
    }

    /**
     * Get User Access Token (Login).
     *
     * @param email
     * @param password
     * @return
     * @throws BaseException
     */
    public AccessToken getUserAccessToken(String email, String password) throws BaseException {
        try {
            Map<String, String> parameters = new HashMap<>();
            parameters.put("email", email);
            parameters.put("password", password);

            Response response = this.sendRequest("/users/login", Request.METHOD_POST, parameters);
            return (AccessToken) makeModel(AccessToken.class, response.getBody());
        } catch (BaseHttpException e) {
            throw new BaseException(500, e.getMessage());
        }
    }

    public UserService userService() {
        return this.userService;
    }

    private void bootstrapServices() {
        this.userService = new UserService(this);
    }
}
