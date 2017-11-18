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
     * Channel Notification Meta
     */
    private String notification_meta;

    /**
     * Channel is_private
     */
    private String is_private;

    /**
     * Return Channel is_private
     *
     * @return
     */
    public String getIs_private() {
        return is_private;
    }

    /**
     * Set Channel is_private
     *
     * @param is_private
     * @return
     */
    public Channel setIs_private(String is_private) {
        this.is_private = is_private;
        return this;
    }

    /**
     * Get Channel Notification Meta
     *
     * @return notification_meta
     */
    public String getNotification_meta() {
        return notification_meta;
    }

    /**
     * Set Channel Notification Meta
     *
     * @param notification_meta
     * @return
     */
    public Channel setNotification_meta(String notification_meta) {
        this.notification_meta = notification_meta;
        return this;
    }

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
     * Get Channel Name
     *
     * @return Name
     */
    public String getName() {
        return name;
    }

    /**
     * Channel Name
     *
     * @param name
     * @return
     */
    public Channel setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get Channel Description
     *
     * @return Description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Channel Description
     *
     * @param description
     * @return
     */
    public Channel setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get Channel Color
     *
     * @return Color
     */
    public String getColor() {
        return color;
    }

    /**
     * Channel Color
     *
     * @param color
     * @return
     */
    public Channel setColor(String color) {
        this.color = color;
        return this;
    }

    /**
     * Get Channel Type
     *
     * @return Type
     */
    public String getType() {
        return type;
    }

    /**
     * Channel Type
     *
     * @param type
     * @return
     */
    public Channel setType(String type) {
        this.type = type;
        return this;
    }

    /**
     * Get Channel User_id
     *
     * @return User_id
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * Channel User_id
     *
     * @param user_id
     * @return
     */
    public Channel setUser_id(Integer user_id) {
        this.user_id = user_id;
        return this;
    }

    /**
     * Get Channel Team_id
     *
     * @return Team_id
     */
    public Integer getTeam_id() {
        return team_id;
    }

    /**
     * Channel Team_id
     *
     * @param team_id
     * @return
     */
    public Channel setTeam_id(Integer team_id) {
        this.team_id = team_id;
        return this;
    }

    /**
     * Get Channel Slug
     *
     * @return Slug
     */
    public String getSlug() {
        return slug;
    }

    /**
     * Channel Slug
     *
     * @param slug
     * @return
     */
    public Channel setSlug(String slug) {
        this.slug = slug;
        return this;
    }
}
