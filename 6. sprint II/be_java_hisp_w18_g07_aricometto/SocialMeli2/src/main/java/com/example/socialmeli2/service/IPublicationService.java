package com.example.socialmeli2.service;

import com.example.socialmeli2.dto.request.PublicationRequest;
import com.example.socialmeli2.dto.response.UserFollowedPublicationResponse;

public interface IPublicationService {

    void registerPublication(PublicationRequest publicationRequest);

    UserFollowedPublicationResponse getUserFollowedPublicationsById(Integer userId, String order);

}
