package com.crypto.exchange.common.biz.service.impl;

import com.crypto.exchange.authentication.biz.mapper.UserMapper;
import com.crypto.exchange.authentication.biz.repository.UserRepository;
import com.crypto.exchange.authentication.model.dto.UserDto;
import com.crypto.exchange.common.biz.service.UpdateUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateUserServiceImpl implements UpdateUserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto update(UserDto userDto) {
        var user = userMapper.map(userDto);
        return userMapper.map(userRepository.save(user));
    }
}
