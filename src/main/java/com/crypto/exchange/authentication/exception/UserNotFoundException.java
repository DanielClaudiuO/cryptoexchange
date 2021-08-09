package com.crypto.exchange.authentication.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("User not found!");
    }

    public UserNotFoundException(String message, Exception exception) {
        super(message, exception);
    }

    public UserNotFoundException(String message) {
        super(message);
    }

}
