package com.example.SocialMeli2.dto.respose;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode
public class PostFollowedByDateDTORes {
    private Integer user_id;
    private List<PostDTORes> posts;
}
