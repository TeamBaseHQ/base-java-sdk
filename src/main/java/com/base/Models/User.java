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


    /**
     * User Name
     *
     * @return Name
     */
    public String getName() {
        return name;
    }

    /**
     * User Name
     *
     * @param name
     * @return
     */
    public User setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * User Email
     *
     * @return Email
     */
    public String getEmail() {
        return email;
    }

    /**
     * User Email`
     *
     * @param email
     * @return
     */
    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * User IsVerified
     *
     * @return IsVerified
     */
    public boolean getIsVerified() {
        return is_verified;
    }

    /**
     * User IsVerified
     *
     * @param is_verified
     * @return
     */
    public User setIsVerified(boolean is_verified) {
        this.is_verified = is_verified;
        return this;
    }
}
