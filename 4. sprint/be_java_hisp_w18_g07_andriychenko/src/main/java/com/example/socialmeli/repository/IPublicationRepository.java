package com.example.socialmeli.repository;

import com.example.socialmeli.entity.PublicationEntity;

import java.util.Map;

public interface IPublicationRepository {

    Boolean addPublication(PublicationEntity publicationEntity);

    PublicationEntity getEntityById(Integer id);

    Map<Integer, PublicationEntity> getAllEntity();

}
