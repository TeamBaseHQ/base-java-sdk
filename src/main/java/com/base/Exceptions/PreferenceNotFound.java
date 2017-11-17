package com.base.Exceptions;

public class PreferenceNotFound extends BaseException {
    /**
     * Construct {@link PreferenceNotFound} with Name and call the {@link BaseException} with Error Code
     *
     * @param name Team slug of team
     */
    public PreferenceNotFound(String name) {
        super(404, "Preferences with name " + name + " was not found.");
    }
}
