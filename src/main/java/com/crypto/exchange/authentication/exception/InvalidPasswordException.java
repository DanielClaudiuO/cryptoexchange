package com.crypto.exchange.authentication.exception;

public class InvalidPasswordException extends RuntimeException {

    public InvalidPasswordException() {
        super("Invalid Password!");
    }

    public InvalidPasswordException(String message, Exception exception) {
        super(message, exception);
    }

    public InvalidPasswordException(String message) {
        super(message);
    }
}
