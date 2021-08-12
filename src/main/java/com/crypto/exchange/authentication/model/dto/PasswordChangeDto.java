package com.crypto.exchange.authentication.model.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class PasswordChangeDto {

    @SerializedName("oldPassword")
    private String oldPassword;

    @SerializedName("newPassword")
    private String newPassword;
}
