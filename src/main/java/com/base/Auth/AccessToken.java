package com.base.Auth;

public class AccessToken {

    /**
     * Access Token access_token
     */
    private String access_token;

    /**
     * Access Token expired_in
     */
    private String expired_in;

    /**
     * Access Token refresh_token
     */
    private String refresh_token;

    /**
     * Default Constructor with one argument which set access_token
     *
     * @param access_token
     */
    public AccessToken(String access_token) {
        this.access_token = access_token;
    }

    /**
     * Default Constructor which get three arguments and set this three arguments
     * @param access_token
     * @param expired_in
     * @param refresh_token
     */
    public AccessToken(String access_token, String expired_in, String refresh_token) {
        this.access_token = access_token;
        this.expired_in = expired_in;
        this.refresh_token = refresh_token;
    }

    /**
     * Get AccessToken
     * @return AccessToken
     */
    public String getAccessToken() {
        return access_token;
    }

    /**
     *  Set access_token
     * @param access_token
     * @return
     */
    public AccessToken setAccessToken(String access_token) {
        this.access_token = access_token;
        return this;
    }

    /**
     * Get ExpiredIn
     * @return ExpiredIn
     */
    public String getExpiredIn() {
        return expired_in;
    }

    /**
     *  Set expired_in
     * @param expired_in
     * @return
     */
    public AccessToken setExpiredIn(String expired_in) {
        this.expired_in = expired_in;
        return this;
    }

    /**
     * Get RefreshToken
     * @return RefreshToken
     */
    public String getRefreshToken() {
        return refresh_token;
    }

    /**
     *  Set refresh_token
     * @param refresh_token
     * @return
     */
    public AccessToken setRefreshToken(String refresh_token) {
        this.refresh_token = refresh_token;
        return this;
    }

    public String toString() {
        return this.getAccessToken();
    }
}
