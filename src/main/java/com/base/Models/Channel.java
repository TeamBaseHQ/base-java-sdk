package com.base.Models;

public class Channel extends BaseModel {

    /**
     * Channel name
     */
    private String name;
    /**
     * Channel description
     */
    private String description;
    /**
     * Channel color
     */
    private String color;
    /**
     * Channel type
     */
    private String type;
    /**
     * Channel user_id
     */
    private Integer user_id;
    /**
     * Channel team_id
     */
    private Integer team_id;
    /**
     * Channel slug
     */
    private String slug;

    /**
     * Channel Owner
     */
    private User owner;

    /**
     * Channel Owner
     *
     * @return User
     */
    public User getOwner() {
        return owner;
    }

    /**
     * Set Channel Owner
     *
     * @param owner
     * @return
     */
    public Channel setOwner(User owner) {
        this.owner = owner;
        return this;
    }

    /**
     * Return Channel Name
     *
     * @return Name
     */
    public String getName() {
        return name;
    }

    /**
     * Set Channel Name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return Channel Description
     *
     * @return Description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set Channel Description
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Return Channel Color
     *
     * @return Color
     */
    public String getColor() {
        return color;
    }

    /**
     * Set Channel Color
     *
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Return Channel Type
     *
     * @return Type
     */
    public String getType() {
        return type;
    }

    /**
     * Set Channel Type
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Return Channel User_id
     *
     * @return User_id
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * Set Channel User_id
     *
     * @param user_id
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    /**
     * Return Channel Team_id
     *
     * @return Team_id
     */
    public Integer getTeam_id() {
        return team_id;
    }

    /**
     * Set Channel Team_id
     *
     * @param team_id
     */
    public void setTeam_id(Integer team_id) {
        this.team_id = team_id;
    }

    /**
     * Return Channel Slug
     *
     * @return Slug
     */
    public String getSlug() {
        return slug;
    }

    /**
     * Set Channel Slug
     *
     * @param slug
     */
    public void setSlug(String slug) {
        this.slug = slug;
    }

}
