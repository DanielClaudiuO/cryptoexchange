package com.crypto.exchange.authentication.controller;

import com.crypto.exchange.authentication.biz.repository.UserRepository;
import com.crypto.exchange.authentication.biz.service.RegisterService;
import com.crypto.exchange.authentication.model.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class AuthController {

    @Autowired
    RegisterService registerService;

    @Autowired
    UserRepository userRepository;

    @PostMapping
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto user) {
        return new ResponseEntity<>(registerService.registerUser(user), HttpStatus.CREATED);
    }

}
