package com.crypto.exchange.common.biz.service.impl;

import com.crypto.exchange.authentication.biz.repository.UserRepository;
import com.crypto.exchange.common.biz.service.GetUserByEmailService;
import com.crypto.exchange.authentication.exception.UserFoundException;
import com.crypto.exchange.authentication.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetUserByEmailServiceImpl implements GetUserByEmailService {

    private final UserRepository userRepository;

    @Override
    public User findUserByEmail(String email) throws UserFoundException {
        return userRepository.findUserByEmail(email).orElseThrow(UserFoundException::new);
    }
}
