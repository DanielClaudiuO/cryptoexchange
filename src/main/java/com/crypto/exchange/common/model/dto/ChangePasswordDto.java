package com.crypto.exchange.common.model.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ChangePasswordDto {

    @SerializedName("oldPassword")
    private String oldPassword;

    @SerializedName("newPassword")
    private String newPassword;
}
