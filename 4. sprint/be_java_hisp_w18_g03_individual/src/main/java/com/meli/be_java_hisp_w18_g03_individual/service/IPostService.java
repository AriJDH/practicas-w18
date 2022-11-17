package com.meli.be_java_hisp_w18_g03_individual.service;


import com.meli.be_java_hisp_w18_g03_individual.dto.request.RequestPostDTO;
import com.meli.be_java_hisp_w18_g03_individual.dto.response.ResponseDTO;
import com.meli.be_java_hisp_w18_g03_individual.dto.response.SellersPostDTO;

public interface IPostService {

    ResponseDTO createPost(RequestPostDTO request);

    SellersPostDTO getPostSellers(Integer userId, String order);
}
