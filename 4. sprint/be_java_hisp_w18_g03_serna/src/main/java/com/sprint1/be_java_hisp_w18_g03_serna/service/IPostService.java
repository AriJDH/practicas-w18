package com.sprint1.be_java_hisp_w18_g03_serna.service;


import com.sprint1.be_java_hisp_w18_g03_serna.dto.request.RequestPostDTO;
import com.sprint1.be_java_hisp_w18_g03_serna.dto.request.RequestPostPromoDTO;
import com.sprint1.be_java_hisp_w18_g03_serna.dto.response.PostCheaperDTO;
import com.sprint1.be_java_hisp_w18_g03_serna.dto.response.PromoProductsCountDTO;
import com.sprint1.be_java_hisp_w18_g03_serna.dto.response.ResponseDTO;
import com.sprint1.be_java_hisp_w18_g03_serna.dto.response.SellersPostDTO;

public interface IPostService {

    ResponseDTO createPost(RequestPostDTO request);

    SellersPostDTO getPostSellers(Integer userId, String order);

    ResponseDTO postPromo(RequestPostPromoDTO request);

    PromoProductsCountDTO promoCountByUser(Integer userId);
    PostCheaperDTO cheaperByUser(Integer userId);
}
