package com.sprint1.be_java_hisp_w18_g03.service;


import com.sprint1.be_java_hisp_w18_g03.dto.request.PromoPostDTORequest;
import com.sprint1.be_java_hisp_w18_g03.dto.request.RequestPostDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.PromoPostCountDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.ResponseDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.SellersPostDTO;

public interface IPostService {

    ResponseDTO createPost(RequestPostDTO request);

    ResponseDTO createPromoPost(PromoPostDTORequest promoPostDTORequest);

    SellersPostDTO getPostSellers(Integer userId, String order);

    PromoPostCountDTO getPostPromoCount(Integer userId);
}
