package com.crypto.exchange.authentication.biz.service;

import com.crypto.exchange.authentication.model.User;

public interface RegisterUserSearchService {

    User findUserByEmail(String email);
}
