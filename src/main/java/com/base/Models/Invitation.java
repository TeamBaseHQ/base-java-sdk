package com.base.Models;

public class Invitation extends BaseModel {

    /**
     * Invitation email
     */
    private String email;
    /**
     * Invitation message
     */
    private String message;
    /**
     * Invitation is_accepted
     */
    private String is_accepted;
    /**
     * Invitation team_id
     */
    private String team_id;

    /**
     * Get Invitation Email
     *
     * @return Email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set Invitation Email
     *
     * @param email
     * @return
     */
    public Invitation setEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * Get Invitation Message
     *
     * @return Message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set Invitation Message
     *
     * @param message
     * @return
     */
    public Invitation setMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * Get Invitation Is_accepted
     *
     * @return Is_accepted
     */
    public String getIs_accepted() {
        return is_accepted;
    }

    /**
     * Set Invitation Is_accepted
     *
     * @param is_accepted
     * @return
     */
    public Invitation setIs_accepted(String is_accepted) {
        this.is_accepted = is_accepted;
        return this;
    }

    /**
     * Get Invitation Team_id
     *
     * @return Team_id
     */
    public String getTeam_id() {
        return team_id;
    }

    /**
     * Set Invitation Team_id
     *
     * @param team_id
     * @return
     */
    public Invitation setTeam_id(String team_id) {
        this.team_id = team_id;
        return this;
    }
}
