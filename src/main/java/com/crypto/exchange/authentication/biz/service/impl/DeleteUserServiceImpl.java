package com.crypto.exchange.authentication.biz.service.impl;

import com.crypto.exchange.authentication.biz.repository.UserRepository;
import com.crypto.exchange.authentication.biz.service.DeleteUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteUserServiceImpl implements DeleteUserService {

    private final UserRepository userRepository;

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
