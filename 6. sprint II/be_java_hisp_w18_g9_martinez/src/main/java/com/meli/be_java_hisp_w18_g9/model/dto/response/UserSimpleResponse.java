package com.meli.be_java_hisp_w18_g9.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSimpleResponse {

    // ? =============== Attributes =============== ?

    @JsonProperty("user_id")
    @NotNull(message = "The user_id field cannot be null")
    @Positive(message = "The user_id field must be greater than zero")
    private Integer userId;

    @JsonProperty("user_name")
    @NotBlank(message = "User name is required")
    @Max(value = 15, message = "The user name must have a maximum of 15 characters")
    private String userName;

}
