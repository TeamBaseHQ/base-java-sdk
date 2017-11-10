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

    public String getSubject() {
        return subject;
    }

    public Thread setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Thread setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getUser_id() {
        return user_id;
    }

    public Thread setUser_id(String user_id) {
        this.user_id = user_id;
        return this;
    }

    public String getChannel_id() {
        return channel_id;
    }

    public Thread setChannel_id(String channel_id) {
        this.channel_id = channel_id;
        return this;
    }

    public String getSlug() {
        return slug;
    }

    public Thread setSlug(String slug) {
        this.slug = slug;
        return this;
    }
}
