package com.crypto.exchange.authentication.model.dto;

import com.crypto.exchange.common.enums.Role;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.Date;

@Data
public class UserDto {

    @SerializedName("id")
    private Long id;

    @SerializedName("name")
    private String name;

    @SerializedName("username")
    private String username;

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    @SerializedName("dateCreated")
    private Date dateCreated;

    @SerializedName("dateModified")
    private Date dateModified;

    @SerializedName("role")
    private Role role;

    @SerializedName("isActive")
    private Boolean isActive;
}
