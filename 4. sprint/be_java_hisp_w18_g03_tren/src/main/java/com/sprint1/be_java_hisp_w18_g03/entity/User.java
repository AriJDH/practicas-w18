package com.sprint1.be_java_hisp_w18_g03.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer userId;
    private String userName;
    private List<User> listFollowed = new ArrayList<>();
    private List<User> listFollowers = new ArrayList<>();

    public User(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
