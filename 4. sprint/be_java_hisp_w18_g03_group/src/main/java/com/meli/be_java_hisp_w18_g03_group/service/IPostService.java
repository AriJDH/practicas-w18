package com.meli.be_java_hisp_w18_g03_group.service;


import com.meli.be_java_hisp_w18_g03_group.dto.request.RequestPostDTO;
import com.meli.be_java_hisp_w18_g03_group.dto.response.ResponseDTO;
import com.meli.be_java_hisp_w18_g03_group.dto.response.SellersPostDTO;

public interface IPostService {

    ResponseDTO createPost(RequestPostDTO request);

    SellersPostDTO getPostSellers(Integer userId, String order);
}
