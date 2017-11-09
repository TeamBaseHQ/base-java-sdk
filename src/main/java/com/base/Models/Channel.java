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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Integer team_id) {
        this.team_id = team_id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

}
