package com.crypto.exchange.authentication.biz.service.impl;

import com.crypto.exchange.authentication.biz.repository.UserRepository;
import com.crypto.exchange.authentication.biz.repository.VerificationTokenRepository;
import com.crypto.exchange.authentication.biz.service.RegisterUserTokenService;
import com.crypto.exchange.authentication.exception.EmailFailureException;
import com.crypto.exchange.authentication.exception.TokenExpiredException;
import com.crypto.exchange.authentication.exception.UserNotFoundException;
import com.crypto.exchange.authentication.model.VerificationToken;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RegisterUserTokenServiceImpl implements RegisterUserTokenService {

    private final UserRepository userRepository;
    private final VerificationTokenRepository verificationTokenRepository;

    @Override
    public void verifyAccount(String token) {
        Optional<VerificationToken> verificationToken = verificationTokenRepository.findByToken(token);
        fetchUserAndEnable(verificationToken.orElseThrow(() -> new EmailFailureException("Invalid Token")));
    }

    private void fetchUserAndEnable(VerificationToken verificationToken) {
        validateToken(verificationToken);
        var user = userRepository.findById(verificationToken.getUserId()).orElseThrow(UserNotFoundException::new);
        user.setIsActive(true);
        verificationToken.setExpiryDate(Instant.now());
        verificationTokenRepository.save(verificationToken);
        userRepository.save(user);
    }

    private void validateToken(VerificationToken verificationToken) {
        if (verificationToken.getExpiryDate().isBefore(Instant.now())) {
            throw new TokenExpiredException();
        }
    }
}
