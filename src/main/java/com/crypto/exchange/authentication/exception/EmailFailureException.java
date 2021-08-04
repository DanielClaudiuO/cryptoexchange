package com.crypto.exchange.authentication.exception;

public class EmailFailureException extends RuntimeException {

    public EmailFailureException(String message, Exception exception) {
        super(message, exception);
    }

    public EmailFailureException(String message) {
        super(message);
    }
}
