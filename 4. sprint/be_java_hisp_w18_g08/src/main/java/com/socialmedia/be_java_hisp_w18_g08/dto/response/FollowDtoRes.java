package com.socialmedia.be_java_hisp_w18_g08.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowDtoRes {

    private Integer statusCode;
    private String message;

}
