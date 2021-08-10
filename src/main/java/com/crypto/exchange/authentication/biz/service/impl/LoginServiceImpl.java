package com.crypto.exchange.authentication.biz.service.impl;

import com.crypto.exchange.authentication.biz.mapper.UserMapper;
import com.crypto.exchange.authentication.biz.repository.UserRepository;
import com.crypto.exchange.authentication.biz.service.LoginService;
import com.crypto.exchange.authentication.exception.InvalidPasswordException;
import com.crypto.exchange.authentication.exception.UserNotFoundException;
import com.crypto.exchange.authentication.model.dto.LoginDto;
import com.crypto.exchange.authentication.model.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public UserDto login(LoginDto loginDto) throws UserNotFoundException {
        var user = userRepository.findUserByEmail(loginDto.getEmail()).orElseThrow(UserNotFoundException::new);

        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            throw new InvalidPasswordException();
        }

        return userMapper.map(user);
    }
}
