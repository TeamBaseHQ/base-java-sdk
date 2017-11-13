package com.base.Models;

public class ResponseModel {

    /**
     * Response data
     */
    protected Object data;

    /**
     * Response links
     */
    protected Object links;

    /**
     * Response meta
     */
    protected Object meta;

    /**
     * Response Mode Meta
     *
     * @return Meta
     */
    public Object getMeta() {
        return meta;
    }

    /**
     * Response Model Meta
     *
     * @param meta
     * @return
     */
    public ResponseModel setMeta(Object meta) {
        this.meta = meta;
        return this;
    }

    /**
     * Response Mode Links
     *
     * @return Links
     */
    public Object getLinks() {
        return links;
    }

    /**
     * Response Model Links
     *
     * @param links
     * @return
     */
    public ResponseModel setLinks(Object links) {
        this.links = links;
        return this;
    }

    /**
     * Response Mode Data
     *
     * @return Data
     */
    public Object getData() {
        return data;
    }

    /**
     * Response Model Data
     *
     * @param data
     * @return
     */
    public ResponseModel setData(Object data) {
        this.data = data;
        return this;
    }
}
