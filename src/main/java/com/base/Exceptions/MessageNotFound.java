package com.base.Exceptions;

public class MessageNotFound extends BaseException {
    public MessageNotFound(String messageSlug) {
        super(404, "Message with slug " + messageSlug + " was not found.");
    }
}
