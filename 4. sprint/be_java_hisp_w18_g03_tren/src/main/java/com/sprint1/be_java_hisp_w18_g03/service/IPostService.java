package com.sprint1.be_java_hisp_w18_g03.service;


import com.sprint1.be_java_hisp_w18_g03.dto.request.RequestPostDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.ProductCountPromoDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.ResponseDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.SellersPostDTO;

public interface IPostService {

    ResponseDTO createPost(RequestPostDTO request);

    SellersPostDTO getPostSellers(Integer userId, String order);

    ProductCountPromoDTO findProductsPromo(Integer userId);
}
