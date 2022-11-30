package com.socialmedia2.be_java_hisp_w18_g08.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.FollowDtoRes;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.FollowedDto;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.UserDto;

import java.util.Arrays;
import java.util.List;

public class Response {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String getFollowDtoRes(int id1, int id2) throws JsonProcessingException {
        String msg = "User with id:" + id1 + " already follow to Seller with id:" + id2;
        FollowDtoRes res = new FollowDtoRes(200, msg);
        return objectMapper.writeValueAsString(res);
    }

    public static String getFollowdDtoRes() throws JsonProcessingException {
        UserDto u1 = new UserDto(5, "User5");
        UserDto u2 = new UserDto(6, "User6");
        UserDto u3 = new UserDto(7, "User7");
        UserDto u4 = new UserDto(8, "User8");
        List<UserDto> lista = Arrays.asList(u1, u2, u3, u4);
        FollowedDto response = new FollowedDto(1, "User1", lista);

        return objectMapper.writeValueAsString(response);
    }
}
