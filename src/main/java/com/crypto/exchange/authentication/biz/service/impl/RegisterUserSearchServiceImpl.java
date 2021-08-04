package com.crypto.exchange.authentication.biz.service.impl;

import com.crypto.exchange.authentication.biz.repository.UserRepository;
import com.crypto.exchange.authentication.biz.service.RegisterUserSearchService;
import com.crypto.exchange.authentication.exception.UserFoundException;
import com.crypto.exchange.authentication.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterUserSearchServiceImpl implements RegisterUserSearchService {

    private final UserRepository userRepository;

    @Override
    public User findUserByEmail(String email) throws UserFoundException {
        return userRepository.findUserByEmail(email).orElseThrow(UserFoundException::new);
    }
}
