package com.crypto.exchange.authentication.biz.service.impl;

import static com.crypto.exchange.common.enums.Role.ADMIN;

import com.crypto.exchange.authentication.biz.mapper.UserMapper;
import com.crypto.exchange.authentication.biz.repository.UserRepository;
import com.crypto.exchange.authentication.biz.repository.VerificationTokenRepository;
import com.crypto.exchange.authentication.biz.service.RegisterUserCreateService;
import com.crypto.exchange.authentication.biz.service.RegisterUserValidationService;
import com.crypto.exchange.authentication.exception.EmailAlreadyTakenException;
import com.crypto.exchange.authentication.model.NotificationEmail;
import com.crypto.exchange.authentication.model.User;
import com.crypto.exchange.authentication.model.VerificationToken;
import com.crypto.exchange.authentication.model.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RegisterUserCreateServiceImpl implements RegisterUserCreateService {

    private static final String MSG_SUBJECT = "Please Activate";
    private static final String MSG_SIGN_UP = "Thank you for signing up to the platform ";
    private static final String MSG_URL_INSTRUCTIONS = "please click on the below url to activate your account :";
    private static final String ACTIVATION_URL = "http://localhost:8080/api/v1/users/verification/";

    private final UserRepository userRepository;
    private final RegisterUserValidationService registerUserValidationService;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final VerificationTokenRepository verificationTokenRepository;
    private final MailServiceImpl mailService;

    @Override
    public void registerUser(UserDto userDto) throws EmailAlreadyTakenException {
        registerUserValidationService.validate(userDto.getEmail());
        var user = userMapper.map(userDto);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setDateCreated(new Date());
        user.setDateModified(new Date());
        user.setRole(ADMIN);
        user.setIsActive(false);
        userRepository.save(user);
        var token = generateVerificationToken(user);
        var notificationEmail = new NotificationEmail(MSG_SUBJECT, user.getEmail(), MSG_SIGN_UP + MSG_URL_INSTRUCTIONS + ACTIVATION_URL + token);
        mailService.sendMail(notificationEmail);
    }

    private String generateVerificationToken(User user) {
        var token = UUID.randomUUID().toString();
        var verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);

        verificationTokenRepository.save(verificationToken);
        return token;
    }
}
