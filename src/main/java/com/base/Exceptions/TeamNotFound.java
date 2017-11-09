package com.base.Exceptions;

public class TeamNotFound extends BaseException{
    public TeamNotFound(String slug) {
        super(404, "Team with Slug " + slug + " was not found.");
    }
}
