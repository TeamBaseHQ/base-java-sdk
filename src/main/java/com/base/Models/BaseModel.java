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

    private String expectedPattern = "y-M-d H:m:s";

    public int getId() {
        return id;
    }

    public BaseModel setId(int id) {
        this.id = id;
        return this;
    }

    public Date getCreated_at() {
        return this.makeDate(this.created_at);
    }

    public BaseModel setCreated_at(String created_at) {
        this.created_at = created_at;
        return this;
    }

    public Date getUpdated_at() {
        return this.makeDate(this.created_at);
    }

    public BaseModel setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
        return this;
    }

    private Date makeDate(String dateTime) {
        SimpleDateFormat formatter = new SimpleDateFormat(this.expectedPattern);
        try
        {
            Date date = formatter.parse(dateTime);
            return date;
        }
        catch (ParseException e)
        {
            return new Date();
        }
    }
}
