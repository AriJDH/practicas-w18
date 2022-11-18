package com.meli.be_java_hisp_w18_g03_individual.service;


import com.meli.be_java_hisp_w18_g03_individual.dto.request.RequestPostDTO;
import com.meli.be_java_hisp_w18_g03_individual.dto.request.RequestPromoPostDTO;
import com.meli.be_java_hisp_w18_g03_individual.dto.response.PromoPostCountDTO;
import com.meli.be_java_hisp_w18_g03_individual.dto.response.ResponseDTO;
import com.meli.be_java_hisp_w18_g03_individual.dto.response.SellerPostDTO;
import com.meli.be_java_hisp_w18_g03_individual.dto.response.SellerPromoPostResponseDTO;

public interface IPostService {

    ResponseDTO createPost(RequestPostDTO request);
    ResponseDTO createPromoPost(RequestPromoPostDTO request);
    SellerPostDTO getPostSellers(Integer userId, String order);
    PromoPostCountDTO getPromoPostCountUser(Integer userId);
    SellerPromoPostResponseDTO getPromoPostListUser(Integer userId);
}
