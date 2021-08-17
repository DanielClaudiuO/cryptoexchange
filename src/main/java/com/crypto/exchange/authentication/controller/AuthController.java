package com.crypto.exchange.authentication.controller;

import com.crypto.exchange.authentication.biz.service.LoginService;
import com.crypto.exchange.authentication.biz.service.RegisterUserCreateService;
import com.crypto.exchange.authentication.biz.service.RegisterUserTokenService;
import com.crypto.exchange.authentication.exception.UserFoundException;
import com.crypto.exchange.authentication.model.dto.LoginDto;
import com.crypto.exchange.authentication.model.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@AllArgsConstructor
public class AuthController {

    private final RegisterUserCreateService registerUserCreateService;
    private final RegisterUserTokenService registerUserTokenService;
    private final LoginService loginService;

    @PostMapping("/register")
    @ExceptionHandler(UserFoundException.class)
    public ResponseEntity<String> registerUser(@RequestBody UserDto user) {
        registerUserCreateService.registerUser(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody LoginDto loginDto) {
        return new ResponseEntity<>(loginService.login(loginDto), HttpStatus.OK);
    }

    @GetMapping("/verify/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token) {
        registerUserTokenService.verifyAccount(token);
        return new ResponseEntity<>("Account Activated Successfully", HttpStatus.OK);
    }
}
