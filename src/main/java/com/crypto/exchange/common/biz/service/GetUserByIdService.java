package com.crypto.exchange.common.biz.service;

import com.crypto.exchange.authentication.model.dto.UserDto;

public interface GetUserByIdService {

    UserDto getUserById(Long id);
}
