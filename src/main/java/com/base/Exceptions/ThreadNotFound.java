package com.base.Exceptions;

public class ThreadNotFound extends BaseException {
    /**
     * Construct {@link ThreadNotFound} with Thread Slug and call the {@link BaseException} with Error Code
     *
     * @param threadSlug Thread Slug of Thread
     */
    public ThreadNotFound(String threadSlug) {
        super(404, "Thread with Slug " + threadSlug + " was not found.");
    }
}
