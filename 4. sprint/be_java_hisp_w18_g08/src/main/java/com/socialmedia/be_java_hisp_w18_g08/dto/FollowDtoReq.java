package com.socialmedia.be_java_hisp_w18_g08.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowDtoReq {

    private Integer userId;
    private Integer userIdToFollow;

}
