package com.crypto.exchange.authentication.biz.service;

import com.crypto.exchange.authentication.model.dto.PasswordChangeDto;
import com.crypto.exchange.authentication.model.dto.UserDto;

public interface PasswordChangeService {

    UserDto changePassword(Long id, PasswordChangeDto passwordChangeDto);
}
