package com.base.Exceptions;

/**
 * Created by Ashim on 09-11-2017.
 */
public class ChannelNotFound extends BaseException {
    public ChannelNotFound(String slug) {
        super(404, "channel with Slug " + slug + " was not found.");
    }
}
