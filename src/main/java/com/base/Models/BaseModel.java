package com.base.Models;

public class BaseModel {

    /**
     * Model id
     */
    protected int id;

    /**
     * Model created_at
     */
    protected String created_at;

    /**
     * Model updated_at
     */
    protected String updated_at;

    public int getId() {
        return id;
    }

    public BaseModel setId(int id) {
        this.id = id;
        return this;
    }

    public String getCreated_at() {
        return created_at;
    }

    public BaseModel setCreated_at(String created_at) {
        this.created_at = created_at;
        return this;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public BaseModel setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
        return this;
    }
}
