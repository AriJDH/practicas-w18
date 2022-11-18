package com.example.socialmeli.service;

import com.example.socialmeli.dto.request.PublicationPromoRequest;
import com.example.socialmeli.dto.request.PublicationRequest;
import com.example.socialmeli.dto.response.PromoCountResponse;
import com.example.socialmeli.dto.response.TopSellersResponse;
import com.example.socialmeli.dto.response.UserFollowedPublicationResponse;

public interface IPublicationService {

    /**
     * US 0005: URL=/products/post
     * @param publicationRequest json with publication data and product data
     */
    void registerPublication(PublicationRequest publicationRequest);
    void registerPromoPublication(PublicationPromoRequest publicationPromoRequest);

    PromoCountResponse getPromoCount(int userId);

    int getNumPromoPosts(int userId);

    TopSellersResponse getTopSellers(String order);

    UserFollowedPublicationResponse getUserFollowedPublicationsById(Integer userId, String order);

}
