package com.meli.be_java_hisp_w18_g9.service;

import com.meli.be_java_hisp_w18_g9.model.dto.request.PostDtoRequest;
import com.meli.be_java_hisp_w18_g9.model.dto.request.PromoPostRequest;
import com.meli.be_java_hisp_w18_g9.model.dto.response.PostDtoResponse;
import com.meli.be_java_hisp_w18_g9.model.dto.response.PostListByFollowedResponse;
import com.meli.be_java_hisp_w18_g9.model.dto.response.PromoPostListByUserResponse;
import com.meli.be_java_hisp_w18_g9.model.dto.response.PromoProductsCountResponse;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface IPostService {

    // ? =============== Methods =============== ?

    void addPost(PostDtoRequest postDtoRequest);
    List<PostDtoResponse> findAll();
    PostListByFollowedResponse findPostsByFollowedAndUserId(Integer userId); // US-0006
    PostListByFollowedResponse findPostsByFollowedAndUserIdOrderByDateAsc(Integer userId); // US-0009A
    PostListByFollowedResponse findPostsByFollowedAndUserIdOrderByDateDesc(Integer userId); // US-0019B
    HttpStatus savePromo(PromoPostRequest promoPostRequest); // US-0010
    PromoProductsCountResponse countPromoByUserId(Integer userId); // US-0011
    PromoPostListByUserResponse findPromoByUserId(Integer userId); // US-0012
    HttpStatus disablePromo(Integer promoId); // US-0013
}
