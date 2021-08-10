package com.crypto.exchange.authentication.biz.service;

import com.crypto.exchange.authentication.exception.UserNotFoundException;
import com.crypto.exchange.authentication.model.dto.LoginDto;
import com.crypto.exchange.authentication.model.dto.UserDto;

public interface LoginService {

    UserDto login(LoginDto loginDto) throws UserNotFoundException;
}
