package com.base.Services;


import com.base.Base;
import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.UserNotFound;
import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Models.Media;
import com.base.Models.User;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class UserService {

    private Base base;

    public UserService(Base base) {
        this.base = base;
    }

    /**
     * Get User By ID.
     *
     * @param user_id
     * @return
     * @throws UserNotFound
     */
    public User getUser(String user_id) throws UserNotFound {
        try {
            Response response = this.base.sendRequest("/users/".concat(user_id), Request.METHOD_GET);
            return (User) Base.makeModel(User.class, response.getBody());
        } catch (BaseHttpException e) {
            throw new UserNotFound(user_id);
        }
    }

    /**
     * Get Currently Logged in User.
     *
     * @return
     * @throws UserNotFound
     */
    public User getCurrentUser() throws UserNotFound {
        return this.getUser("me");
    }

    public User createUser(String name, String email, String password) throws BaseHttpException {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("name", name);
        parameters.put("email", email);
        parameters.put("password", password);
        parameters.put("password_confirmation", password);

        Response response = this.base.sendRequest("/users", Request.METHOD_POST, parameters);
        return (User) Base.makeModel(User.class, response.getBody());
    }

    /**
     * Update a User.
     *
     * @param name Name
     * @param email Email
     * @param password Password
     *
     * @return Updated User
     *
     * @throws BaseHttpException Exception.
     */
    public User updateUser(String name, String email, String password) throws BaseHttpException {
        Map<String, String> parameters = new HashMap<>();

        if (!name.isEmpty()) {
            parameters.put("name", name);
        }

        if (!email.isEmpty()) {
            parameters.put("email", email);
        }

        if (!password.isEmpty()) {
            parameters.put("password", password);
            parameters.put("password_confirmation", password);
        }

        Response response = this.base.sendRequest("/users/me", Request.METHOD_PATCH, parameters);
        System.out.println(response.getBody());
        return (User) Base.makeModel(User.class, response.getBody());
    }


    /**
     * Upload Current User's Profile Picture.
     *
     * @param picture
     * @return
     * @throws BaseHttpException
     */
    public Media uploadProfilePicture(File picture) throws BaseHttpException {
        Map<String, String> parameters = new HashMap<>();

        Map<String, File> files = new HashMap<>();
        files.put("file", picture);

        Response response = this.base.sendRequest("/users/picture", Request.METHOD_POST, parameters, new HashMap<>(),
                files);
        return (Media) Base.makeModel(Media.class, response.getBody());
    }
}
