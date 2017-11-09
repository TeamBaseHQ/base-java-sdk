package com.base.Models;

public class Team extends  BaseModel{


    /*
     *  Team name
     */

    private String name;
    /*
     *  Team description
     */

    private String description;
    /*
     *  Team invitation_code
     */

    private String invitation_code;
    /*
     *  Team user_id
     */

    private String user_id;
    /*
     *  Team slug
     */

    private String slug;

    public String getName() {
        return name;
    }

    public Team setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Team setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getInvitation_code() {
        return invitation_code;
    }

    public Team setInvitation_code(String invitation_code) {
        this.invitation_code = invitation_code;
        return this;
    }

    public String getUser_id() {
        return user_id;
    }

    public Team setUser_id(String user_id) {
        this.user_id = user_id;
        return this;
    }

    public String getSlug() {
        return slug;
    }

    public Team setSlug(String slug) {
        this.slug = slug;
        return this;
    }
}
