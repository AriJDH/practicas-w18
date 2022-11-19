package com.example.socialmeli.repository;

import com.example.socialmeli.entity.PublicationEntity;
import com.example.socialmeli.exception.NotFoundException;
import com.example.socialmeli.repository.interfaces.IPublicationRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PublicationRepositoryImpl implements IPublicationRepository {

    private Map<Integer, PublicationEntity> publications = new HashMap<Integer, PublicationEntity>();
    private Integer publicationId = 0;

    @Override
    public Boolean addEntity(PublicationEntity publicationEntity) {
        publicationId++;
        publicationEntity.setId(publicationId);
        publications.put(publicationId, publicationEntity);
        return true;
    }

    @Override
    public PublicationEntity getEntityById(Integer publicationId) {
        if (this.publications.get(publicationId) == null) {
            throw new NotFoundException("No existe publicacion con la promocion con ID: " + publicationId);
        }

        return publications.get(publicationId);
    }

    @Override
    public Map<Integer, PublicationEntity> getAllEntity() {
        return publications;
    }

}
