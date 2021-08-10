package com.crypto.exchange.authentication.model.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class LoginDto {

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;
}
