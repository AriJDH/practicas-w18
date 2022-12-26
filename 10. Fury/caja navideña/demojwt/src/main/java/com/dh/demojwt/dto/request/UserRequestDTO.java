package com.dh.demojwt.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor

public class UserRequestDTO {
    @JsonProperty("user_name")
    private String userName;
    private String password;
}
