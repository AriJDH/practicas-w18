package com.example.SocialMeli2.dto.respose;

import com.example.SocialMeli2.entity.UserBuyer;
import com.example.SocialMeli2.entity.UserSeller;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
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
