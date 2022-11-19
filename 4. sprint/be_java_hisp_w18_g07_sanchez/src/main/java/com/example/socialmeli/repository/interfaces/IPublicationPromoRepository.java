package com.example.socialmeli.repository.interfaces;

import com.example.socialmeli.entity.PostProductPromEntity;

import java.util.Map;

public interface IPublicationPromoRepository {

    Boolean addEntity(PostProductPromEntity publicationEntity);

    PostProductPromEntity getEntityById(Integer publicationId);

    Map<Integer, PostProductPromEntity> getAllEntity();

}
