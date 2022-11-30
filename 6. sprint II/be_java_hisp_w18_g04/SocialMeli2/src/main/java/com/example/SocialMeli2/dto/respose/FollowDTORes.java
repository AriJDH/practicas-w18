package com.example.SocialMeli2.dto.respose;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode
public class FollowDTORes {
    private String userName;
    private String userNameFollowed;
}
