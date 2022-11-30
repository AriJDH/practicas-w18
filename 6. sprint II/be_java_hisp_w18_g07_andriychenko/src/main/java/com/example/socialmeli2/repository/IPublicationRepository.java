package com.example.socialmeli2.repository;

import com.example.socialmeli2.entity.PublicationEntity;

import java.util.Map;

public interface IPublicationRepository {

    Boolean addEntity(PublicationEntity publicationEntity);

    PublicationEntity getEntityById(Integer publicationId);

    Map<Integer, PublicationEntity> getAllEntity();

}
