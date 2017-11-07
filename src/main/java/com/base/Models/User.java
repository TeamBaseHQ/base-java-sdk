package com.base.Models;

public class User extends BaseModel {

    /**
     * User name.
     */
    protected String name;

    /**
     * User email.
     */
    protected String email;

    /**
     * Is Verified
     */
    protected boolean is_verified;


    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public boolean isVerified() {
        return is_verified;
    }

    public User setIsVerified(boolean is_verified) {
        this.is_verified = is_verified;
        return this;
    }
}
