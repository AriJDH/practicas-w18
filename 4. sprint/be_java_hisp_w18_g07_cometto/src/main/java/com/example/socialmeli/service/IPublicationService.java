package com.example.socialmeli.service;

import com.example.socialmeli.dto.request.PublicationPromotionRequest;
import com.example.socialmeli.dto.request.PublicationRequest;
import com.example.socialmeli.dto.response.PublicationPromotionCountResponse;
import com.example.socialmeli.dto.response.PublicationPromotionSumResponse;
import com.example.socialmeli.dto.response.UserFollowedPublicationResponse;

public interface IPublicationService {

    /**
     * US 0005: URL=/products/post
     * @param publicationRequest json with publication data and product data
     */
    void registerPublication(PublicationRequest publicationRequest);

    void registerPublicationPromotion(PublicationPromotionRequest publicationPromotionRequest);
    UserFollowedPublicationResponse getUserFollowedPublicationsById(Integer userId, String order);
    PublicationPromotionCountResponse countPublicationPromotionById(Integer userId);
    PublicationPromotionSumResponse sumPublicationPromotionById(Integer userId);

}
