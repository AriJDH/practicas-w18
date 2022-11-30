package com.example.SocialMeli2.dto.respose;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode
public class FollowedListDTORes {
    private Integer user_id;
    private String user_name;
    private List<UserDTORes> followed;

}
