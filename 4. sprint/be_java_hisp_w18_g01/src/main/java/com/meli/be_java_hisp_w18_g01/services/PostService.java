package com.meli.be_java_hisp_w18_g01.services;

import com.meli.be_java_hisp_w18_g01.dtos.PostDTO;
import com.meli.be_java_hisp_w18_g01.dtos.ResponseDTO;

public interface PostService {

    ResponseDTO addPost(PostDTO postDTO);
}
