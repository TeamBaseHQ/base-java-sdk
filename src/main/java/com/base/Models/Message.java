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

    /**
     * Message Owner
     */
    private User owner;

    /**
     * Get Message Owner
     *
     * @return User
     */
    public User getOwner() {
        return owner;
    }

    /**
     * Set Message Owner
     *
     * @param owner
     * @return
     */
    public Message setOwner(User owner) {
        this.owner = owner;
        return this;
    }

    /**
     * Message Content
     *
     * @return Content
     */
    public String getContent() {
        return content;
    }

    /**
     * Set Message Content
     *
     * @param content
     * @return
     */
    public Message setContent(String content) {
        this.content = content;
        return this;
    }

    /**
     * Message Type
     *
     * @return Type
     */
    public String getType() {
        return type;
    }

    /**
     * Set Message Type
     *
     * @param type
     * @return
     */
    public Message setType(String type) {
        this.type = type;
        return this;
    }

    /**
     * Message Thread_id
     *
     * @return Thread_id
     */
    public String getThread_id() {
        return thread_id;
    }

    /**
     * Set Message Thread_id
     *
     * @param thread_id
     * @return
     */
    public Message setThread_id(String thread_id) {
        this.thread_id = thread_id;
        return this;
    }

    /**
     * Message Sender_id
     *
     * @return Sender_id
     */
    public String getSender_id() {
        return sender_id;
    }

    /**
     * Set Message Sender_id
     *
     * @param sender_id
     * @return
     */
    public Message setSender_id(String sender_id) {
        this.sender_id = sender_id;
        return this;
    }

    /**
     * Message Sender_type
     *
     * @return Sender_type
     */
    public String getSender_type() {
        return sender_type;
    }

    /**
     * Set Message Sender_type
     *
     * @param sender_type
     * @return
     */
    public Message setSender_type(String sender_type) {
        this.sender_type = sender_type;
        return this;
    }

    /**
     * Message Slug
     *
     * @return Slug
     */
    public String getSlug() {
        return slug;
    }

    /**
     * Set Message Slug
     *
     * @param slug
     * @return
     */
    public Message setSlug(String slug) {
        this.slug = slug;
        return this;
    }
}
