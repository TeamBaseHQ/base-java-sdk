package com.base.Exceptions;

public class UserNotFound extends BaseException {
    /**
     * Construct {@link UserNotFound} with User Slug and call the {@link BaseException} with Error Code
     *
     * @param personId User id of User
     */
    public UserNotFound(String personId) {
        super(404, "Person with id " + personId + " was not found.");
    }
}
