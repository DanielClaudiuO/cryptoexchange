package com.crypto.exchange.authentication.biz.service;

import com.crypto.exchange.authentication.model.dto.UserDto;

public interface GetUserByIdService {

    UserDto getByIdService(Long id);
}
