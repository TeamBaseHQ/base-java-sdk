package com.base.Services;

import com.base.Base;
import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.Http.NotFound;
import com.base.Exceptions.PreferenceNotFound;
import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Models.Preference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PreferenceService {

    /**
     * {@link Base}
     */
    private Base base;

    /**
     * Construct Instance of Base Class
     *
     * @param base
     */
    public PreferenceService(Base base) {
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
    public Preference savePreference(String name, String value, String category) throws BaseHttpException {
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("value", value);
        parameters.put("category", category);
        parameters.put("name", name);
        String URL = "/preferences/".concat(name);
        Response response = this.base.sendRequest(URL, Request.METHOD_PUT, parameters);
        return (Preference) Base.makeModel(Preference.class, response.getBody());
    }

    /**
     * Get All The Preference of User
     *
     * @return List of Preference
     * @throws BaseHttpException Exception
     */
    public List<Preference> getAllPreferences() throws BaseHttpException {
        String URL = "/preferences";
        Response response = this.base.sendRequest(URL, Request.METHOD_GET);
        Preference[] preferencesArray = (Preference[]) Base.makeModel(Preference[].class, response.getBody());
        return new ArrayList<>(Arrays.asList(preferencesArray));
    }


    /**
     * Get Perfereneces by name
     *
     * @param name
     * @return Preference
     * @throws PreferenceNotFound Exception
     * @throws BaseHttpException  Exception
     */
    public Preference getPreference(String name) throws PreferenceNotFound, BaseHttpException {
        try {
            String URL = "/preferences/".concat(name);
            Response response = this.base.sendRequest(URL, Request.METHOD_GET);
            return (Preference) Base.makeModel(Preference.class, response.getBody());
        } catch (NotFound e) {
            throw new PreferenceNotFound(name);
        }
    }

    /**
     * Delete Preference By name
     *
     * @param name
     * @return Boolean
     * @throws BaseHttpException  Exception
     * @throws PreferenceNotFound Exception
     */
    public boolean deletePreference(String name) throws BaseHttpException, PreferenceNotFound {
        try {
            String URL = "/preferences/".concat(name);
            Response response = this.base.sendRequest(URL, Request.METHOD_DELETE);
            return true;
        } catch (NotFound e) {
            throw new PreferenceNotFound(name);
        }
    }


}
