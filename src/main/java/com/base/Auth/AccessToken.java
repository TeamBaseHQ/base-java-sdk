package com.base.Auth;

public class AccessToken {
    private String access_token;

    private String expired_in;

    private String refresh_token;

    public AccessToken(String access_token) {
        this.access_token = access_token;
    }

    public AccessToken(String access_token, String expired_in, String refresh_token) {
        this.access_token = access_token;
        this.expired_in = expired_in;
        this.refresh_token = refresh_token;
    }

    public String getAccessToken() {
        return access_token;
    }

    public AccessToken setAccessToken(String access_token) {
        this.access_token = access_token;
        return this;
    }

    public String getExpiredIn() {
        return expired_in;
    }

    public AccessToken setExpiredIn(String expired_in) {
        this.expired_in = expired_in;
        return this;
    }

    public String getRefreshToken() {
        return refresh_token;
    }

    public AccessToken setRefreshToken(String refresh_token) {
        this.refresh_token = refresh_token;
        return this;
    }

    public String toString() {
        return this.getAccessToken();
    }
}
