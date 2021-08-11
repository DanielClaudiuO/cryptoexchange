package com.crypto.exchange.authentication.biz.service.impl;

import com.crypto.exchange.authentication.biz.mapper.UserMapper;
import com.crypto.exchange.authentication.biz.repository.UserRepository;
import com.crypto.exchange.authentication.biz.service.PasswordChangeService;
import com.crypto.exchange.authentication.exception.InvalidPasswordException;
import com.crypto.exchange.authentication.exception.UserFoundException;
import com.crypto.exchange.authentication.model.dto.PasswordChangeDto;
import com.crypto.exchange.authentication.model.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PasswordChangeServiceImpl implements PasswordChangeService {

    private final UserRepository repository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto changePassword(Long id, PasswordChangeDto passwordDto) {
        var user = repository.findById(id).orElse(null);

        if (user == null) {
            throw new UserFoundException();
        }
        if (!passwordEncoder.matches(passwordDto.getOldPassword(), user.getPassword())) {
            throw new InvalidPasswordException();
        }

        user.setPassword(passwordEncoder.encode(passwordDto.getNewPassword()));

        return userMapper.map(repository.save(user));
    }
}
