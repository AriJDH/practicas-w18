package com.dh.be_java_hisp_w18_g10.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("user_name")
    private String userName;

    private Map<Integer, User> followers = new HashMap<>();
    private Map<Integer, User> follow = new HashMap<>();
    private Map<Integer, Post> posts = new HashMap<>();

}
