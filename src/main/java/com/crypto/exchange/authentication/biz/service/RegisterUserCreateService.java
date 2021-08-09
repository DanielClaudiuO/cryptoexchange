package com.crypto.exchange.authentication.biz.service;

import com.crypto.exchange.authentication.exception.EmailAlreadyTakenException;
import com.crypto.exchange.authentication.model.dto.UserDto;

public interface RegisterUserCreateService {

    void registerUser(UserDto user) throws EmailAlreadyTakenException;
}
