package com.crypto.exchange.common.biz.service.impl;

import com.crypto.exchange.authentication.biz.mapper.UserMapper;
import com.crypto.exchange.authentication.biz.repository.UserRepository;
import com.crypto.exchange.authentication.exception.InvalidPasswordException;
import com.crypto.exchange.authentication.exception.UserNotFoundException;
import com.crypto.exchange.authentication.model.dto.UserDto;
import com.crypto.exchange.common.biz.service.ChangePasswordService;
import com.crypto.exchange.common.model.dto.ChangePasswordDto;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ChangePasswordServiceImpl implements ChangePasswordService {

    private final UserRepository repository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto changePassword(Long id, ChangePasswordDto passwordDto) {
        var user = repository.findById(id).orElseThrow(UserNotFoundException::new);

        if (!passwordEncoder.matches(passwordDto.getOldPassword(), user.getPassword())) {
            throw new InvalidPasswordException();
        }

        user.setPassword(passwordEncoder.encode(passwordDto.getNewPassword()));

        return userMapper.map(repository.save(user));
    }
}
