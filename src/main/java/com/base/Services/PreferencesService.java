package com.base.Services;

import com.base.Base;
import com.base.Exceptions.BaseHttpException;
import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Models.Preferences;

import java.util.HashMap;

public class PreferencesService {

    /**
     * {@link Base}
     */
    private Base base;

    /**
     * Construct Instance of Base Class
     *
     * @param base
     */
    public PreferencesService(Base base) {
        this.base = base;
    }


    /**
     * Save New Preference of User
     *
     * @param value
     * @param category
     * @param name
     * @return Preference
     * @throws BaseHttpException Exception
     */
    public Preferences createPreferences(String name, String value, String category) throws BaseHttpException {
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("value", value);
        parameters.put("category", category);
        parameters.put("name", name);
        String URL = "/preferences/".concat(name);
        Response response = this.base.sendRequest(URL, Request.METHOD_PUT, parameters);
        return (Preferences) Base.makeModel(Preferences.class, response.getBody());
    }

}
