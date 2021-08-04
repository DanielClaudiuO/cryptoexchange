package com.crypto.exchange.authentication.biz.service;

public interface RegisterUserTokenService {

    void verifyAccount(String token);
}
