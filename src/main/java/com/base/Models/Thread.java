package com.base.Models;

public class Thread extends BaseModel {

    /*
     *  Thread subject
     */
    private String subject;
    /*
     *  Thread description
     */
    private String description;
    /*
     *  Thread user_id
     */
    private String user_id;
    /*
     *  Thread channel_id
     */
    private String channel_id;
    /*
     *  Thread slug
     */
    private String slug;

    /**
     * Thread Owner
     */
    private User owner;

    /**
     * Get Thread Owner
     *
     * @return User
     */
    public User getOwner() {
        return owner;
    }

    /**
     * Set Thread Owner
     *
     * @param owner
     * @return
     */
    public Thread setOwner(User owner) {
        this.owner = owner;
        return this;
    }

    /**
     * Return Thread Subject
     *
     * @return Subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Thread Subject
     *
     * @param subject
     * @return
     */
    public Thread setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    /**
     * Return Thread Description
     *
     * @return Description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Thread Description
     *
     * @param description
     * @return
     */
    public Thread setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Return Thread User_id
     *
     * @return User_id
     */
    public String getUser_id() {
        return user_id;
    }

    /**
     * Thread User_id
     *
     * @param user_id
     * @return
     */
    public Thread setUser_id(String user_id) {
        this.user_id = user_id;
        return this;
    }

    /**
     * Return Thread Channel_id
     *
     * @return Channel_id
     */
    public String getChannel_id() {
        return channel_id;
    }

    /**
     * Thread Channel_id
     *
     * @param channel_id
     * @return
     */
    public Thread setChannel_id(String channel_id) {
        this.channel_id = channel_id;
        return this;
    }

    /**
     * Return Thread Slug
     *
     * @return Slug
     */
    public String getSlug() {
        return slug;
    }

    /**
     * Thread Slug
     *
     * @param slug
     * @return
     */
    public Thread setSlug(String slug) {
        this.slug = slug;
        return this;
    }
}
