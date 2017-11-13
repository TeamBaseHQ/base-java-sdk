package com.base.Auth;

public class AccessToken {

    /**
     * Users {@link AccessToken} access_token
     */
    private String access_token;

    /**
     * Users {@link AccessToken} expired_in
     */
    private String expired_in;

    /**
     * Users {@link AccessToken} refresh_token
     */
    private String refresh_token;

    /**
     * Construct {@link AccessToken} with specified access_token
     *
     * @param access_token
     */
    public AccessToken(String access_token) {
        this.access_token = access_token;
    }

    /**
     * Construct {@link AccessToken} with access_token,expired_in,refresh_token
     *
     * @param access_token  AccessToken of User
     * @param expired_in    After how many time the access token will be expired
     * @param refresh_token refresh token for the access token
     */
    public AccessToken(String access_token, String expired_in, String refresh_token) {
        this.access_token = access_token;
        this.expired_in = expired_in;
        this.refresh_token = refresh_token;
    }

    /**
     * Return the  access_token of User
     *
     * @return AccessToken
     */
    public String getAccessToken() {
        return access_token;
    }

    /**
     * Set access_token
     *
     * @param access_token
     * @return
     */
    public AccessToken setAccessToken(String access_token) {
        this.access_token = access_token;
        return this;
    }

    /**
     * Get Return the  expired_in of User
     *
     * @return ExpiredIn
     */
    public String getExpiredIn() {
        return expired_in;
    }

    /**
     * Set expired_in
     *
     * @param expired_in
     * @return
     */
    public AccessToken setExpiredIn(String expired_in) {
        this.expired_in = expired_in;
        return this;
    }

    /**
     * Get Return the  refresh_token of User
     *
     * @return RefreshToken
     */
    public String getRefreshToken() {
        return refresh_token;
    }

    /**
     * Set refresh_token
     *
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
