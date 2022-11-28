package com.example.SocialMeli2.dto.respose;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class FollowedListDTORes {
    private Integer user_id;
    private String user_name;
    private List<UserDTORes> followed;

}
