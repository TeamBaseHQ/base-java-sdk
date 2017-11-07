package com.base.Exceptions;

public class UserNotFound extends BaseException {
    public UserNotFound(String personId) {
        super(404, "Person with id " + personId + " was not found.");
    }
}
