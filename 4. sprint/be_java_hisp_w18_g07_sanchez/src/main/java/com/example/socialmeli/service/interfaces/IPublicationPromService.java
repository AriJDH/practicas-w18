package com.example.socialmeli.service.interfaces;

import com.example.socialmeli.dto.request.PostProductPromRequest;
import com.example.socialmeli.dto.response.UserPostPromoCountResponse;

public interface IPublicationPromService {

    /**
     * US 0010: URL=/products/promo-post
     * @param postProductPromRequest json with publication data and product data
     */
    void registerPublicationProm(PostProductPromRequest postProductPromRequest);

    UserPostPromoCountResponse getUserPromProductCount(Integer userId);

}
