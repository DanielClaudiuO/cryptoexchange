package com.crypto.exchange.authentication.biz.service.impl;

import com.crypto.exchange.authentication.biz.repository.UserRepository;
import com.crypto.exchange.authentication.biz.repository.VerificationTokenRepository;
import com.crypto.exchange.authentication.biz.service.RegisterUserTokenService;
import com.crypto.exchange.authentication.exception.EmailFailureException;
import com.crypto.exchange.authentication.model.VerificationToken;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RegisterUserTokenServiceImpl implements RegisterUserTokenService {

    private final UserRepository userRepository;
    private final VerificationTokenRepository verificationTokenRepository;

    @Override
    public void verifyAccount(String token) {
        Optional<VerificationToken> verificationToken = verificationTokenRepository.getToken(token);
        fetchUserAndEnable(verificationToken.orElseThrow(() -> new EmailFailureException("Invalid Token")));
    }

    private void fetchUserAndEnable(VerificationToken verificationToken) {
        String username = verificationToken.getUser().getUsername();
        var user = userRepository.findByUsername(username).orElseThrow(() -> new EmailFailureException("User not found with name - " + username));
        user.setIsActive(true);
        userRepository.save(user);
    }
}
