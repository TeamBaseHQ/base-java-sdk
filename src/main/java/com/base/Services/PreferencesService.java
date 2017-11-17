package com.base.Services;

import com.base.Base;
import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.Http.NotFound;
import com.base.Exceptions.PreferencesNotFound;
import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Models.Preferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

    /**
     * Get All The Preferences of User
     *
     * @return List of Preferences
     * @throws BaseHttpException Exception
     */
    public List<Preferences> getAllPreferencess() throws BaseHttpException {
        String URL = "/preferences";
        Response response = this.base.sendRequest(URL, Request.METHOD_GET);
        Preferences[] preferencesArray = (Preferences[]) Base.makeModel(Preferences[].class, response.getBody());
        return new ArrayList<>(Arrays.asList(preferencesArray));
    }


    /**
     * Get Perfereneces by name
     *
     * @param name
     * @return
     * @throws PreferencesNotFound Exception
     * @throws BaseHttpException   Exception
     */
    public Preferences getPreferences(String name) throws PreferencesNotFound, BaseHttpException {
        try {
            String URL = "/preferences/".concat(name);
            Response response = this.base.sendRequest(URL, Request.METHOD_GET);
            return (Preferences) Base.makeModel(Preferences.class, response.getBody());
        } catch (NotFound e) {
            throw new PreferencesNotFound(name);
        }
    }


}
