package com.socialmedia2.be_java_hisp_w18_g08.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.FollowDtoRes;

public class Response {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String getFollowDtoRes(int id1, int id2) throws JsonProcessingException {
        String msg = "User with id:" + id1 + " already follow to Seller with id:" + id2;
        FollowDtoRes res = new FollowDtoRes(200, msg);
        return objectMapper.writeValueAsString(res);
    }
}
