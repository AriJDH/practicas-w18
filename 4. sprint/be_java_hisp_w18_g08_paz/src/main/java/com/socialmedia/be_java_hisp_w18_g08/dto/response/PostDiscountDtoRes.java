package com.socialmedia.be_java_hisp_w18_g08.dto.response;

import com.socialmedia.be_java_hisp_w18_g08.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostDiscountDtoRes {

    private Integer user_id;
    private String user_name;
    private List<Post> posts;
}
