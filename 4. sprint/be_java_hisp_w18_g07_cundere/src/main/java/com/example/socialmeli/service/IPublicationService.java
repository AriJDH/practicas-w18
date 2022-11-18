package com.example.socialmeli.service;

import com.example.socialmeli.dto.request.PublicationPromoRequest;
import com.example.socialmeli.dto.request.PublicationRequest;
import com.example.socialmeli.dto.response.PublicationPromoCountResponse;
import com.example.socialmeli.dto.response.PublicationResponse;
import com.example.socialmeli.dto.response.UserFollowedPublicationResponse;

import java.util.List;

public interface IPublicationService {

    /**
     * US 0005: URL=/products/post
     *
     * @param publicationRequest json with publication data and product data
     */
    void registerPublication(PublicationRequest publicationRequest);

    void registerPublicationPromo(PublicationPromoRequest publicationPromoRequest);

    UserFollowedPublicationResponse getUserFollowedPublicationsById(Integer userId, String order);

    List<PublicationResponse> getPublicationResponseListByPriceRange(Integer minPrice, Integer maxPrice);

    PublicationPromoCountResponse getPublicationPromoCountByUserId(Integer userId);

}
