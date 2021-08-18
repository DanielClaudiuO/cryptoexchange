package com.crypto.exchange.common.controller;

import com.crypto.exchange.authentication.model.User;
import com.crypto.exchange.authentication.model.dto.UserDto;
import com.crypto.exchange.common.biz.service.DeleteUserService;
import com.crypto.exchange.common.biz.service.GetUserByEmailService;
import com.crypto.exchange.common.biz.service.GetUserByIdService;
import com.crypto.exchange.common.biz.service.ChangePasswordService;
import com.crypto.exchange.common.biz.service.UpdateUserService;
import com.crypto.exchange.common.model.dto.ChangePasswordDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserController {

    private final ChangePasswordService passwordChangeService;
    private final GetUserByEmailService registerUserSearchService;
    private final GetUserByIdService getByIdService;
    private final UpdateUserService updateService;
    private final DeleteUserService deleteService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> findUserById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(getByIdService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping(params = "email")
    public ResponseEntity<User> findUserByEmail(@RequestParam(value = "email") String email) {
        return new ResponseEntity<>(registerUserSearchService.findUserByEmail(email), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user) {
        return new ResponseEntity<>(updateService.update(user), HttpStatus.OK);
    }

    @PatchMapping("/{id}/password")
    public ResponseEntity<UserDto> passwordChange(@PathVariable Long id, @RequestBody ChangePasswordDto passwordChangeDto) {
        return new ResponseEntity<>(passwordChangeService.changePassword(id, passwordChangeDto), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id) {
        deleteService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
