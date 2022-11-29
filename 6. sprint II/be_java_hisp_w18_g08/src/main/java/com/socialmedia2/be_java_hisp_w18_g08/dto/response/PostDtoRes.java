package com.socialmedia2.be_java_hisp_w18_g08.dto.response;

import com.socialmedia2.be_java_hisp_w18_g08.dto.PostDto;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class PostDtoRes {
    private Integer user_id;
    private List<PostDto> posts;
}
