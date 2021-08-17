package com.crypto.exchange.common.biz.service;

import com.crypto.exchange.common.model.dto.PasswordChangeDto;
import com.crypto.exchange.authentication.model.dto.UserDto;

public interface PasswordChangeService {

    UserDto changePassword(Long id, PasswordChangeDto passwordChangeDto);
}
