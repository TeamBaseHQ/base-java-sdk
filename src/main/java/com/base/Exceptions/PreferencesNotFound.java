package com.base.Exceptions;

public class PreferencesNotFound extends BaseException {
    /**
     * Construct {@link PreferencesNotFound} with Name and call the {@link BaseException} with Error Code
     *
     * @param name Team slug of team
     */
    public PreferencesNotFound(String name) {
        super(404, "Preferences with name " + name + " was not found.");
    }
}
