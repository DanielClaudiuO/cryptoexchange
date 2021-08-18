package com.crypto.exchange.common.biz.service;

import com.crypto.exchange.authentication.model.User;

public interface GetUserByEmailService {

    User findUserByEmail(String email);
}
