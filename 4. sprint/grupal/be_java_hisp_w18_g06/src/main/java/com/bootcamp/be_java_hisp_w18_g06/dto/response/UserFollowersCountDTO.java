package com.bootcamp.be_java_hisp_w18_g06.dto.response;

import lombok.Getter;

@Getter
public class UserFollowersCountDTO {
    //US-002
    private int user_id;
    private String user_name;
    private int followers_count; //TODO Setear el valor desde el service
}
