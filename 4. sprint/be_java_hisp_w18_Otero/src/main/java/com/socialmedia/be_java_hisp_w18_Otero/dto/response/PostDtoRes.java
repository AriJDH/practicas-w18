package com.socialmedia.be_java_hisp_w18_Otero.dto.response;

import com.socialmedia.be_java_hisp_w18_Otero.dto.PostDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class PostDtoRes {
    private Integer user_id;
    private List<PostDto> posts;
}
