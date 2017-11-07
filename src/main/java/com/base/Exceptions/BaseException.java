package com.base.Exceptions;

public class BaseException extends Exception {

    public BaseException() {
        super("Error (500): Something went wrong.");
    }

    public BaseException(int code, String error) {
        super("Error ("+ code +"): " + error);
    }

}
