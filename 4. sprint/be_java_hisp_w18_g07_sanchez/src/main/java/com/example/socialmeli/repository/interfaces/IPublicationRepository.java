package com.example.socialmeli.repository.interfaces;

import com.example.socialmeli.entity.PublicationEntity;

import java.util.Map;

public interface IPublicationRepository {

    Boolean addEntity(PublicationEntity publicationEntity);

    PublicationEntity getEntityById(Integer publicationId);

    Map<Integer, PublicationEntity> getAllEntity();

}
