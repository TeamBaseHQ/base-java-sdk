package com.base.Http.Server.Responses;

import com.base.Models.ResponseModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

abstract public class BaseResponse implements ServerResponseInterface {

    protected static Gson gson = null;

    public BaseResponse() {
        if (BaseResponse.gson == null) {
            GsonBuilder builder = new GsonBuilder();
            BaseResponse.gson = builder.create();
        }
    }


    /**
     * Generate Response Body from Model.
     *
     * @param model Model.
     * @return JSON Data.
     */
    public static String generateResponseBody(Object model) {
        ResponseModel response = new ResponseModel();
        response.setData(model);
        return gson.toJson(response);
    }

}
