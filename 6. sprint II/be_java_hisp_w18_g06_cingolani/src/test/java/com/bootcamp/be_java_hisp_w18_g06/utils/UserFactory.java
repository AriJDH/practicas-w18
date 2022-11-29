package com.bootcamp.be_java_hisp_w18_g06.utils;

import com.bootcamp.be_java_hisp_w18_g06.dto.response.UserFollowDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.UserFollowedListDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.UserFollowersCountDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.UserFollowersListDTO;
import com.bootcamp.be_java_hisp_w18_g06.entity.Post;
import com.bootcamp.be_java_hisp_w18_g06.entity.User;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserFactory {

    private static final ObjectMapper mapper = JsonMapper.builder()
            .findAndAddModules()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .build();

    public static User getUserRandom(String name) {
        return new User((int) (Math.random() * 10), name);
    }

    public static User getUserId(Integer id) {
        return new User(id);
    }

    public static User getUserWithFollowedList(String name) {
        User user = getUserRandom(name);
        List<User> userList = new ArrayList<>();
        userList.add(getUserRandom("user 1"));
        userList.add(getUserRandom("user 2"));
        userList.add(getUserRandom("user 3"));
        user.setFollowed(userList);
        return user;
    }

    public static User getUserWithFollowersList(String name) {
        User user = getUserRandom(name);
        List<User> userList = new ArrayList<>();
        userList.add(getUserRandom("user 1"));
        userList.add(getUserRandom("user 2"));
        userList.add(getUserRandom("user 3"));
        user.setFollowers(userList);
        return user;
    }

    public static User getUserWithFollowersListAndPosts(String name) {
        User user = getUserRandom(name);
        List<User> userList = new ArrayList<>();
        //userList.add(getUserRandom("user 1"));
        userList.add(getUserRandom("user 2"));
        userList.add(getUserRandom("user 3"));
        user.setFollowers(userList);
        List<Post> postList = new ArrayList<>();
        Post post1 = new Post();
        post1.setDate(LocalDate.now());
        Post post2 = new Post();
        post2.setDate(LocalDate.now().minusWeeks(1));
        Post post3 = new Post();
        post3.setDate(LocalDate.now().minusWeeks(3));
        postList.add(post2);
        postList.add(post3);
        postList.add(post1);
        user.setPosts(postList);
        return user;
    }

    public static UserFollowDTO getUserFollowDto(String name) {
        return mapper.convertValue(getUserRandom(name), UserFollowDTO.class);
    }

    public static UserFollowersCountDTO getUserFollowCountDto(String name) {
        UserFollowersCountDTO userFollowersCountDTODTO = new UserFollowersCountDTO();
        userFollowersCountDTODTO.setUser_id((int) (Math.random() * 10));
        userFollowersCountDTODTO.setUser_name(name);
        userFollowersCountDTODTO.setFollowers_count((int) (Math.random() * 100));
        return userFollowersCountDTODTO;
    }

    public static UserFollowedListDTO getUserFollowedListDto() {
        User user = getUserWithFollowedList("user followed list");
        UserFollowedListDTO userFollowedListDTO = new UserFollowedListDTO();
        userFollowedListDTO.setUser_id(user.getUser_id());
        userFollowedListDTO.setUser_name(user.getUser_name());
        userFollowedListDTO.setFollowed(user.getFollowed().stream().map( follow -> mapper
                .convertValue(follow, UserFollowDTO.class))
                .collect(Collectors.toList()));
        return userFollowedListDTO;
    }

    public static UserFollowersListDTO getUserFollowersListDto() {
        User user = getUserWithFollowedList("user followed list");
        UserFollowersListDTO userFollowedListDTO = new UserFollowersListDTO();
        userFollowedListDTO.setUser_id(user.getUser_id());
        userFollowedListDTO.setUser_name(user.getUser_name());
        userFollowedListDTO.setFollowers(user.getFollowed().stream().map( follow -> mapper
                .convertValue(follow, UserFollowDTO.class))
                .collect(Collectors.toList()));
        return userFollowedListDTO;
    }

}
