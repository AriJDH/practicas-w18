package com.example.socialmeli.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserFollowerCountResponse {
    private int id;
    private String name;
    private int followers;
}
