package com.crypto.exchange.authentication.exception;

public class EmailAlreadyTakenException extends RuntimeException {

    public EmailAlreadyTakenException() {
        super("Email already taken");
    }

    public EmailAlreadyTakenException(String message, Exception exception) {
        super(message, exception);
    }

    public EmailAlreadyTakenException(String message) {
        super(message);
    }
}
