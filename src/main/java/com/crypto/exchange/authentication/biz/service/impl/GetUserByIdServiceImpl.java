package com.crypto.exchange.authentication.biz.service.impl;

import com.crypto.exchange.authentication.biz.mapper.UserMapper;
import com.crypto.exchange.authentication.biz.repository.UserRepository;
import com.crypto.exchange.authentication.biz.service.GetUserByIdService;
import com.crypto.exchange.authentication.model.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetUserByIdServiceImpl implements GetUserByIdService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto getByIdService(Long id) {
        return userMapper.map(userRepository.findById(id).orElse(null));
    }
}
