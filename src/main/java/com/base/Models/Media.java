package com.base.Models;

import java.util.Map;

public class Media extends BaseModel {

    /**
     * name
     */
    protected String name;

    /**
     * file_name
     */
    protected String file_name;

    /**
     * collection_name
     */
    protected String collection_name;

    /**
     * mime_type
     */
    protected String mime_type;

    /**
     * size
     */
    protected int size;

    /**
     * custom_properties
     */
    protected Object[] custom_properties;

    /**
     * manipulations
     */
    protected Object[] manipulations;

    /**
     * url
     */
    protected Map<String, String> url;

    public String getName() {
        return name;
    }

    public Media setName(String name) {
        this.name = name;
        return this;
    }

    public String getFile_name() {
        return file_name;
    }

    public Media setFile_name(String file_name) {
        this.file_name = file_name;
        return this;
    }

    public String getCollection_name() {
        return collection_name;
    }

    public Media setCollection_name(String collection_name) {
        this.collection_name = collection_name;
        return this;
    }

    public String getMime_type() {
        return mime_type;
    }

    public Media setMime_type(String mime_type) {
        this.mime_type = mime_type;
        return this;
    }

    public int getSize() {
        return size;
    }

    public Media setSize(int size) {
        this.size = size;
        return this;
    }

    public Object[] getCustom_properties() {
        return custom_properties;
    }

    public Media setCustom_properties(Object[] custom_properties) {
        this.custom_properties = custom_properties;
        return this;
    }

    public Object[] getManipulations() {
        return manipulations;
    }

    public Media setManipulations(Object[] manipulations) {
        this.manipulations = manipulations;
        return this;
    }

    public Map<String, String> getUrl() {
        return this.url;
    }

    public String getUrl(String size) {
        return this.url.get(size);
    }

    public Media setUrl(Map<String, String> url) {
        this.url = url;
        return this;
    }
}
