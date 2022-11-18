package com.example.socialmeli.service;

import com.example.socialmeli.dto.request.PublicationRequest;
import com.example.socialmeli.dto.response.UserFollowedPublicationResponse;

public interface IPublicationService {
    boolean registerPublication(PublicationRequest publicationRequest);
    UserFollowedPublicationResponse getUserFollowedPublicationsById(Integer userId, String order);
}
