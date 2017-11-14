package com.base.Exceptions;

public class BaseException extends Exception {

    /**
     * Construct {@link BaseException}
     */
    public BaseException() {
        super("Error (500): Something went wrong.");
    }

    /**
     * Construct {@link BaseException} with status code and Error Message
     * @param code Error Code
     * @param error Error Message
     */
    public BaseException(int code, String error) {
        super("Error ("+ code +"): " + error);
    }

}
