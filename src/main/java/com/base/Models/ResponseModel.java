package com.base.Models;

public class ResponseModel {

    protected Object data;

    protected  Object links;

    protected  Object meta;

    public Object getMeta() {
        return meta;
    }

    public ResponseModel setMeta(Object meta) {
        this.meta = meta;
        return this;
    }

    public Object getLinks() {
        return links;
    }

    public ResponseModel setLinks(Object links) {
        this.links = links;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ResponseModel setData(Object data) {
        this.data = data;
        return this;
    }
}
