package com.base.Exceptions;

public class TeamNotFound extends BaseException {
    /**
     * Construct {@link TeamNotFound} with Team Slug and call the {@link BaseException} with Error Code
     * @param slug Team slug of team
     */
    public TeamNotFound(String slug) {
        super(404, "Team with Slug " + slug + " was not found.");
    }
}
