package com.example.socialmeli.service;

import com.example.socialmeli.dto.request.PublicationPromoRequest;
import com.example.socialmeli.dto.request.PublicationRequest;
import com.example.socialmeli.dto.response.UserFollowedPublicationResponse;
import com.example.socialmeli.dto.response.UserPublicationPromoCountResponse;

public interface IPublicationService {

    /**
     * US 0005: URL=/products/post
     *
     * @param publicationRequest json with publication data and product data
     */
    void registerPublication(PublicationRequest publicationRequest);

    UserFollowedPublicationResponse getUserFollowedPublicationsById(Integer userId, String order);

    void addPublicationPromo(PublicationPromoRequest publicationPromoRequest);

    UserPublicationPromoCountResponse getUserPublicationPromoCount(Integer userId);

}
