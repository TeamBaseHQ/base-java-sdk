package com.base.Models;

public class Team extends BaseModel {


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

    /**
     * Team Owner
     */
    private User owner;

    /**
     * Team Owner
     *
     * @return User
     */
    public User getOwner() {
        return owner;
    }

    /**
     * Set Owner of Team
     *
     * @param owner
     * @return
     */
    public Team setOwner(User owner) {
        this.owner = owner;
        return this;
    }

    /**
     * Return User Name
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
    public Team setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Return User Description
     *
     * @return Description
     */
    public String getDescription() {
        return description;
    }

    /**
     * User Description
     *
     * @param description
     * @return
     */
    public Team setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Return User Invitation_code
     *
     * @return Invitation_code
     */
    public String getInvitation_code() {
        return invitation_code;
    }

    /**
     * User Invitation_code
     *
     * @param invitation_code
     * @return
     */
    public Team setInvitation_code(String invitation_code) {
        this.invitation_code = invitation_code;
        return this;
    }

    /**
     * Return User User_id
     *
     * @return User_id
     */
    public String getUser_id() {
        return user_id;
    }

    /**
     * User User_id
     *
     * @param user_id
     * @return
     */
    public Team setUser_id(String user_id) {
        this.user_id = user_id;
        return this;
    }

    /**
     * Return User Slug
     *
     * @return Slug
     */
    public String getSlug() {
        return slug;
    }

    /**
     * User Slug
     *
     * @param slug
     * @return
     */
    public Team setSlug(String slug) {
        this.slug = slug;
        return this;
    }
}
