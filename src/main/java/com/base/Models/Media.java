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

    /**
     * Return Media Name
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set Media Name
     *
     * @param name
     * @return
     */
    public Media setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Return Media File_name
     *
     * @return
     */
    public String getFile_name() {
        return file_name;
    }

    /**
     * Set Media File_name
     *
     * @param file_name
     * @return
     */
    public Media setFile_name(String file_name) {
        this.file_name = file_name;
        return this;
    }

    /**
     * Return Media Collection_name
     *
     * @return
     */
    public String getCollection_name() {
        return collection_name;
    }

    /**
     * Set Media Collection_name
     *
     * @param collection_name
     * @return
     */
    public Media setCollection_name(String collection_name) {
        this.collection_name = collection_name;
        return this;
    }

    /**
     * Return Media Mime_type
     *
     * @return
     */
    public String getMime_type() {
        return mime_type;
    }

    /**
     * Set Media Mime_type
     *
     * @param mime_type
     * @return
     */
    public Media setMime_type(String mime_type) {
        this.mime_type = mime_type;
        return this;
    }

    /**
     * Return Media Size
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Set Media Size
     *
     * @param size
     * @return
     */
    public Media setSize(int size) {
        this.size = size;
        return this;
    }

    /**
     * Return Media Custom_properties
     *
     * @return
     */
    public Object[] getCustom_properties() {
        return custom_properties;
    }

    /**
     * Set Media Custom_properties
     *
     * @param custom_properties
     * @return
     */
    public Media setCustom_properties(Object[] custom_properties) {
        this.custom_properties = custom_properties;
        return this;
    }

    /**
     * Return Media Manipulations
     *
     * @return
     */
    public Object[] getManipulations() {
        return manipulations;
    }

    /**
     * Set Media Manipulations
     *
     * @param manipulations
     * @return
     */
    public Media setManipulations(Object[] manipulations) {
        this.manipulations = manipulations;
        return this;
    }

    /**
     * Return Media Url
     *
     * @return
     */
    public Map<String, String> getUrl() {
        return this.url;
    }

    /**
     * Set Media Url
     *
     * @param url
     * @return
     */
    public Media setUrl(Map<String, String> url) {
        this.url = url;
        return this;
    }

    /**
     * Return Media Url
     *
     * @param size
     * @return
     */
    public String getUrl(String size) {
        return this.url.get(size);
    }
}
