package com.crypto.exchange.authentication.biz.service.impl;

import com.crypto.exchange.authentication.biz.mapper.UserMapper;
import com.crypto.exchange.authentication.biz.repository.UserRepository;
import com.crypto.exchange.authentication.biz.service.RegisterService;
import com.crypto.exchange.authentication.model.User;
import com.crypto.exchange.authentication.model.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public UserDto registerUser(UserDto userDto) {
        User user = userMapper.map(userDto);

        //var password = user.getPassword();
        //user.setPassword(encrypt(password));
        user.setDateCreated(new Date());
        user.setDateModified(new Date());
        user.setRole("GUEST");

        return userMapper.map(userRepository.save(user));
    }
}
