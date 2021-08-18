package com.crypto.exchange.common.biz.service;

import com.crypto.exchange.authentication.model.dto.UserDto;

public interface UpdateUserService {

    UserDto update(UserDto userDto);
}
