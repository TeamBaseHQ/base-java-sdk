package com.base;

import com.base.Auth.AccessToken;
import com.base.Exceptions.BaseException;
import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.Http.NotFound;
import com.base.Exceptions.PersonNotFound;
import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Models.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

public final class Base {

    protected BaseClient client;

    public Base() {
        this.client = new BaseClient();
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
    protected static Object makeModel(Type model, String jsonData) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.fromJson(jsonData, model);
    }

    /**
     * @param id User ID
     * @return User object.
     * @throws BaseException Exception.
     */
    public User getUser(String id) throws BaseException {
        try {
            Response response = this.client.sendRequest("/users/" + id, Request.METHOD_GET);
            return (User) makeModel(User.class, response.getBody());
        } catch (NotFound e) {
            throw new PersonNotFound(id);
        } catch (BaseHttpException e) {
            throw new BaseException();
        }
    }
}
