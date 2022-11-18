package com.example.BE_java_hisp_w18_g04.repository;

import com.example.BE_java_hisp_w18_g04.dto.request.PostPromoDTOReq;
import com.example.BE_java_hisp_w18_g04.entity.Post;

public interface IPostRepository{
    void createPost(Post post);
    void createPostPromo(PostPromoDTOReq postPromoDTOReq);

}
