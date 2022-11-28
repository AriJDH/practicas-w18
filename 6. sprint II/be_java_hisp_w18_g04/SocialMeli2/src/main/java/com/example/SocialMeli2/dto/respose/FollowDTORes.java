package com.example.SocialMeli2.dto.respose;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class FollowDTORes {
    private String userNameFollower;
    private String userNameFollowed;
}
