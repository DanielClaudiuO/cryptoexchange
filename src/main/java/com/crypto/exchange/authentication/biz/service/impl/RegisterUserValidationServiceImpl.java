package com.crypto.exchange.authentication.biz.service.impl;

import com.crypto.exchange.authentication.biz.repository.UserRepository;
import com.crypto.exchange.authentication.biz.service.RegisterUserValidationService;
import com.crypto.exchange.authentication.exception.UserFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterUserValidationServiceImpl implements RegisterUserValidationService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void validate(String email) throws UserFoundException {
        if (userRepository.findUserByEmail(email).isPresent()) {
            throw new UserFoundException();
        }
    }
}
