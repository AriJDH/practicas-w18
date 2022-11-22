package com.survive.livecoding.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private String name;
    @Size(max = 15, message = "Can't be longer than 15 characters.")
    @NotBlank(message = "Can't be empty.")
    private String lastname;
    @Max(value = 99, message = "Can't be older than 99 years old.")
    private Integer age;
}
