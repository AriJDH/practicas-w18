package com.example.BE_java_hisp_w18_g04.dto.respose;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostFollowedByDateDTORes {
    private Integer user_id;
    private List<PostDTORes> posts;
}
