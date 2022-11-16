package com.sprint1.be_java_hisp_w18_g03.service;

public interface IPostService {

    ResponseDTO createPost(RequestPostDTO request);
    SellerPostDTO getPostSellet(Integer userId);


}
