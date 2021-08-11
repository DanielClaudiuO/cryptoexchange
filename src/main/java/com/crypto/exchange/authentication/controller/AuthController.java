package com.crypto.exchange.authentication.controller;

import com.crypto.exchange.authentication.biz.service.DeleteUserService;
import com.crypto.exchange.authentication.biz.service.GetUserByIdService;
import com.crypto.exchange.authentication.biz.service.LoginService;
import com.crypto.exchange.authentication.biz.service.RegisterUserCreateService;
import com.crypto.exchange.authentication.biz.service.RegisterUserSearchService;
import com.crypto.exchange.authentication.biz.service.RegisterUserTokenService;
import com.crypto.exchange.authentication.biz.service.UpdateUserService;
import com.crypto.exchange.authentication.exception.UserFoundException;
import com.crypto.exchange.authentication.model.User;
import com.crypto.exchange.authentication.model.dto.LoginDto;
import com.crypto.exchange.authentication.model.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class AuthController {

    private final RegisterUserCreateService registerUserCreateService;
    private final RegisterUserSearchService registerUserSearchService;
    private final RegisterUserTokenService registerUserTokenService;
    private final LoginService loginService;
    private final GetUserByIdService getByIdService;
    private final UpdateUserService updateService;
    private final DeleteUserService deleteService;

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

    @GetMapping("/verify/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token) {
        registerUserTokenService.verifyAccount(token);
        return new ResponseEntity<>("Account Activated Successfully", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody LoginDto loginDto) {
        return new ResponseEntity<>(loginService.login(loginDto), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> findUserById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(getByIdService.getByIdService(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user) {
        return new ResponseEntity<>(updateService.update(user), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id) {
        deleteService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
