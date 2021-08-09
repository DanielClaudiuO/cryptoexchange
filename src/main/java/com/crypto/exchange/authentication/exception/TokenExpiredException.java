package com.crypto.exchange.authentication.exception;

public class TokenExpiredException extends RuntimeException {

    public TokenExpiredException() {
        super("Token expired!");
    }

    public TokenExpiredException(String message, Exception exception) {
        super(message, exception);
    }

    public TokenExpiredException(String message) {
        super(message);
    }
}
