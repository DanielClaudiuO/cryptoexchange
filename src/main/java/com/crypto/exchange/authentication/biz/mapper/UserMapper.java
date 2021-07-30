package com.crypto.exchange.authentication.biz.mapper;

import com.crypto.exchange.authentication.model.User;
import com.crypto.exchange.authentication.model.dto.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User map(UserDto source);

    UserDto map(User source);

    List<UserDto> map(List<User> source);
}
