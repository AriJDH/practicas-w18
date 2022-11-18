package com.example.socialmeli.service;

import com.example.socialmeli.dto.request.PublicationRequest;
import com.example.socialmeli.dto.request.PublicationSaleRequest;
import com.example.socialmeli.dto.response.PublicationAllResponse;
import com.example.socialmeli.dto.response.UserFollowedPublicationResponse;
import com.example.socialmeli.dto.response.UserSaleResponse;
import com.example.socialmeli.entity.PublicationEntity;

import java.util.List;
import java.util.Map;

public interface IPublicationService {

    /**
     * US 0005: URL=/products/post
     * @param publicationRequest json with publication data and product data
     */
    void registerPublication(PublicationRequest publicationRequest);
    void registerPublication(PublicationSaleRequest publicationSaleRequest);

    UserFollowedPublicationResponse getUserFollowedPublicationsById(Integer userId, String order);

    UserSaleResponse getSaleCount(Integer userId);

    List<PublicationAllResponse> getAll();

}
