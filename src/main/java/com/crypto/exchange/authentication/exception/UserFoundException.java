package com.crypto.exchange.authentication.exception;

public class UserFoundException extends RuntimeException {

    public UserFoundException() {
        super("User already exists!");
    }

    public UserFoundException(String message, Exception exception) {
        super(message, exception);
    }

    public UserFoundException(String message) {
        super(message);
    }

}
