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
     * @param id
     * @return
     * @throws UserNotFound
     */
    public User find(String id) throws UserNotFound {
        try {
            Response response = this.base.sendRequest("/users/".concat(id), Request.METHOD_GET);
            return (User) Base.makeModel(User.class, response.getBody());
        } catch (BaseHttpException e) {
            throw new UserNotFound(id);
        }
    }

    /**
     * Get Currently Logged in User.
     *
     * @return
     * @throws UserNotFound
     */
    public User getCurrentUser() throws UserNotFound {
        return this.find("me");
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
