package com.socialmedia.be_java_hisp_w18_g08.dto;

import com.socialmedia.be_java_hisp_w18_g08.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class PostDtoRes {
    private Integer user_id;
    private List<Post> posts;
}
