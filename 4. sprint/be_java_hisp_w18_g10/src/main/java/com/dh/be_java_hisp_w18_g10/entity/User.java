package com.dh.be_java_hisp_w18_g10.entity;

import com.dh.be_java_hisp_w18_g10.dto.response.UserDTOres;
import com.dh.be_java_hisp_w18_g10.dto.response.UserFollowersListDTOres;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("user_name")
    private String userName;

    private Map<Integer, User> followers = new HashMap<>();
    private Map<Integer, User> followed = new HashMap<>();
    private Map<Integer, Post> posts = new HashMap<>();

    public List<User> getFollowersList() {
        return new ArrayList<>(followers.values());
    }

    public UserFollowersListDTOres toUserFollowersListDTOres() {

        List<UserDTOres> userDTOresList = getFollowersList()
                .stream()
                .map(user -> new UserDTOres(user.getUserId(), user.getUserName()))
                .collect(Collectors.toList());

        UserFollowersListDTOres userFollowersListDTOres = new UserFollowersListDTOres(userId, userName, userDTOresList);
        userFollowersListDTOres.setUser_id(userId);
        userFollowersListDTOres.setUser_name(userName);

        return userFollowersListDTOres;
    }
}
