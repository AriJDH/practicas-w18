package com.socialmedia.be_java_hisp_w18_Otero.dto.response;

import com.socialmedia.be_java_hisp_w18_Otero.dto.PostDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RankingLikesDto {

    private List<PostDto> post;
}
