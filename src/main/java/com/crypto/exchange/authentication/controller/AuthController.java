package com.crypto.exchange.authentication.controller;

import com.crypto.exchange.authentication.biz.service.RegisterUserCreateService;
import com.crypto.exchange.authentication.biz.service.RegisterUserSearchService;
import com.crypto.exchange.authentication.biz.service.RegisterUserTokenService;
import com.crypto.exchange.authentication.exception.UserFoundException;
import com.crypto.exchange.authentication.model.User;
import com.crypto.exchange.authentication.model.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class AuthController {

    @Autowired
    private RegisterUserCreateService registerUserCreateService;

    @Autowired
    private RegisterUserSearchService registerUserSearchService;

    @Autowired
    private RegisterUserTokenService registerUserTokenService;

    @PostMapping
    @ExceptionHandler(UserFoundException.class)
    public ResponseEntity<String> registerUser(@RequestBody UserDto user) {
        registerUserCreateService.registerUser(user);
        return new ResponseEntity<>("User registered successful", HttpStatus.OK);
    }

    @GetMapping(params = "email")
    public ResponseEntity<User> findUserByEmail(@RequestParam(value = "email") String email) {
        return new ResponseEntity<>(registerUserSearchService.findUserByEmail(email), HttpStatus.OK);
    }

    @GetMapping("verification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token) {
        registerUserTokenService.verifyAccount(token);
        return new ResponseEntity<>("Account Activated Successfully", HttpStatus.OK);
    }

}
