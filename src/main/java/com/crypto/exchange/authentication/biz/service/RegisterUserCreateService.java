package com.crypto.exchange.authentication.biz.service;

import com.crypto.exchange.authentication.model.User;
import com.crypto.exchange.authentication.model.dto.UserDto;

public interface RegisterUserCreateService {

    void registerUser(UserDto user);

    User findUserByEmail(String email);
}
