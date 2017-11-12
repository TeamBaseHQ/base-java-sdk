package com.base.Models;

public class Message extends BaseModel {

    /**
     * Message content
     */
    private String content;

    /**
     * Message type
     */
    private String type;

    /**
     * Message thread_id
     */
    private String thread_id;

    /**
     * Message sender_id
     */
    private String sender_id;

    /**
     * Message sender_type
     */
    private String sender_type;

    /**
     * Message slug
     */
    private String slug;

    public String getContent() {
        return content;
    }

    public Message setContent(String content) {
        this.content = content;
        return this;
    }

    public String getType() {
        return type;
    }

    public Message setType(String type) {
        this.type = type;
        return this;
    }

    public String getThread_id() {
        return thread_id;
    }

    public Message setThread_id(String thread_id) {
        this.thread_id = thread_id;
        return this;
    }

    public String getSender_id() {
        return sender_id;
    }

    public Message setSender_id(String sender_id) {
        this.sender_id = sender_id;
        return this;
    }

    public String getSender_type() {
        return sender_type;
    }

    public Message setSender_type(String sender_type) {
        this.sender_type = sender_type;
        return this;
    }

    public String getSlug() {
        return slug;
    }

    public Message setSlug(String slug) {
        this.slug = slug;
        return this;
    }
}
