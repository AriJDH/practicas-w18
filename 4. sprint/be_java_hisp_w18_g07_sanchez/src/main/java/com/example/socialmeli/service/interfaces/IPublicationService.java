package com.example.socialmeli.service.interfaces;

import com.example.socialmeli.dto.request.PublicationRequest;
import com.example.socialmeli.dto.response.UserFollowedPublicationResponse;

public interface IPublicationService {

    /**
     * US 0005: URL=/products/post
     * @param publicationRequest json with publication data and product data
     */
    void registerPublication(PublicationRequest publicationRequest);
    UserFollowedPublicationResponse getUserFollowedPublicationsById(Integer userId, String order);

}
