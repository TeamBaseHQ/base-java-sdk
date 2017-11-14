package com.base.Exceptions;

public class ChannelNotFound extends BaseException {
    /**
     * Construct {@link ChannelNotFound} with Channel Slug and call the {@link BaseException} with Error Code
     * @param slug Channel Slug of the Channel
     */
    public ChannelNotFound(String slug) {
        super(404, "channel with Slug " + slug + " was not found.");
    }
}
