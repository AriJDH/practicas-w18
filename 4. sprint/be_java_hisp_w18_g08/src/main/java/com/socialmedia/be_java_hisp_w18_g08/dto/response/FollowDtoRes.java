package com.socialmedia.be_java_hisp_w18_g08.dto;

import com.socialmedia.be_java_hisp_w18_g08.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowDtoRes {

    private Integer statusCode;
    private String message;

}
