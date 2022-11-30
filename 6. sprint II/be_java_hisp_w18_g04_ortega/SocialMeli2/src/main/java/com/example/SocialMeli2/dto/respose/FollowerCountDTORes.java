package com.example.SocialMeli2.dto.respose;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode
public class FollowerCountDTORes {
    private Integer user_id;
    private String user_name;
    private Integer followers_count;
}
