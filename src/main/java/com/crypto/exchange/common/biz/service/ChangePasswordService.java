package com.crypto.exchange.common.biz.service;

import com.crypto.exchange.common.model.dto.ChangePasswordDto;
import com.crypto.exchange.authentication.model.dto.UserDto;

public interface ChangePasswordService {

    UserDto changePassword(Long id, ChangePasswordDto passwordChangeDto);
}
