package com.base.Models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    /**
     * Model Pattern for Data
     */
    private String expectedPattern = "y-M-d H:m:s";

    /**
     * Return Model d
     *
     * @return Model Id
     */
    public int getId() {
        return id;
    }

    /**
     * Set Model Id
     *
     * @param id
     * @return
     */
    public BaseModel setId(int id) {
        this.id = id;
        return this;
    }

    /**
     * Return Model Created_at
     *
     * @return Date
     */
    public Date getCreated_at() {
        return this.makeDate(this.created_at);
    }

    /**
     * Set Model Created Date
     *
     * @param created_at
     * @return
     */
    public BaseModel setCreated_at(String created_at) {
        this.created_at = created_at;
        return this;
    }

    /**
     * Return Model Updated_at
     *
     * @return Date
     */
    public Date getUpdated_at() {
        return this.makeDate(this.created_at);
    }

    /**
     * Set Model Updated Date
     *
     * @param updated_at
     * @return
     */
    public BaseModel setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
        return this;
    }

    /**
     * Genrate Data from String and Return it.
     *
     * @param dateTime
     * @return
     */
    private Date makeDate(String dateTime) {
        SimpleDateFormat formatter = new SimpleDateFormat(this.expectedPattern);
        try {
            Date date = formatter.parse(dateTime);
            return date;
        } catch (ParseException e) {
            return new Date();
        }
    }
}
