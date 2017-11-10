package com.base.Exceptions;

public class ThreadNotFound extends BaseException {
    public ThreadNotFound(String threadSlug) {
        super(404, "Thread with Slug " + threadSlug + " was not found.");
    }
}
