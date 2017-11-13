package com.base.Exceptions;

public class MessageNotFound extends BaseException {
    /**
     * Construct {@link MessageNotFound} with Message Slug and call the {@link BaseException} with Error Code
     * @param messageSlug Message Slug of the Message
     */
    public MessageNotFound(String messageSlug) {
        super(404, "Message with slug " + messageSlug + " was not found.");
    }
}
