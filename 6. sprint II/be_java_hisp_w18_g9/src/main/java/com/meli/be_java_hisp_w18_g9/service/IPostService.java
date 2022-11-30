package com.meli.be_java_hisp_w18_g9.service;

import com.meli.be_java_hisp_w18_g9.model.dto.request.PostDtoRequest;
import com.meli.be_java_hisp_w18_g9.model.dto.response.PostDtoResponse;
import com.meli.be_java_hisp_w18_g9.model.dto.response.PostListByFollowedResponse;

import java.util.List;

public interface IPostService {

    // ? =============== Methods =============== ?

    void addPost(PostDtoRequest postDtoRequest);
    List<PostDtoResponse> findAll();
    PostListByFollowedResponse findPostsByFollowedAndUserId(Integer userId);
    PostListByFollowedResponse findPostsByFollowedAndUserIdOrderByDateAsc(Integer userId);
    PostListByFollowedResponse findPostsByFollowedAndUserIdOrderByDateDesc(Integer userId);

}
