package com.bootcamp.be_java_hisp_w18_g06.dto.response;

import lombok.Getter;

import java.util.List;

@Getter
public class UserFollowersListDTO {
    //US-003
    private int user_id;
    private String user_name;
    private List<UserFollowDTO> followers;
}

