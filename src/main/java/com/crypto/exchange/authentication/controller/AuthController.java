package com.crypto.exchange.authentication.controller;

import com.crypto.exchange.authentication.biz.service.RegisterUserCreateService;
import com.crypto.exchange.authentication.model.User;
import com.crypto.exchange.authentication.model.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class AuthController {

    @Autowired
    private RegisterUserCreateService registerUserCreateService;

    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody UserDto user) {
        registerUserCreateService.registerUser(user);
        return new ResponseEntity<>("User registered successful", HttpStatus.OK);
    }

    @GetMapping(params = "email")
    public ResponseEntity<User> findUserByEmail(@RequestParam(value = "email") String email) {
        return new ResponseEntity<>(registerUserCreateService.findUserByEmail(email), HttpStatus.OK);
    }

}
