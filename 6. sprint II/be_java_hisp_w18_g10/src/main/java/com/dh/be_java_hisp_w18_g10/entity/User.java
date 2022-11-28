package com.dh.be_java_hisp_w18_g10.entity;

import com.dh.be_java_hisp_w18_g10.dto.response.UserDTOres;
import com.dh.be_java_hisp_w18_g10.dto.response.UserFollowersListDTOres;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {

    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("user_name")
    private String userName;

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    private Map<Integer, User> followers = new HashMap<Integer, User>();
    private Map<Integer, User> followed = new HashMap<Integer, User>();
    private Map<Integer, Post> posts = new HashMap<Integer, Post>();

}
