package com.example.BE_java_hisp_w18_g04.dto.respose;

import com.example.BE_java_hisp_w18_g04.entity.UserBuyer;
import com.example.BE_java_hisp_w18_g04.entity.UserSeller;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDTORes {
    private Integer user_id;
    private String user_name;

    public UserDTORes(UserBuyer e) {
        this.user_id = e.getUser_id();
        this.user_name = e.getUser_name();
    }
    public UserDTORes(UserSeller e) {
        this.user_id = e.getUser_id();
        this.user_name = e.getUser_name();
    }

}
