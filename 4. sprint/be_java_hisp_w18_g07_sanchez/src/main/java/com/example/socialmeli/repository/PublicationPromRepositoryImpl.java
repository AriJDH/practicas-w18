package com.example.socialmeli.repository;

import com.example.socialmeli.entity.PostProductPromEntity;
import com.example.socialmeli.exception.NotFoundException;
import com.example.socialmeli.repository.interfaces.IPublicationPromoRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PublicationPromRepositoryImpl implements IPublicationPromoRepository {

    private Map<Integer, PostProductPromEntity> publications = new HashMap<Integer, PostProductPromEntity>();
    private Integer publicationId = 0;

    @Override
    public Boolean addEntity(PostProductPromEntity publicationEntity) {
        publicationId++;
        publicationEntity.setId(publicationId);
        publications.put(publicationId, publicationEntity);
        return true;
    }

    @Override
    public PostProductPromEntity getEntityById(Integer publicationId) {
        if (this.publications.get(publicationId) == null) {
            throw new NotFoundException("No existe publicacion con la promocion con ID: " + publicationId);
        }

        return publications.get(publicationId);
    }

    @Override
    public Map<Integer, PostProductPromEntity> getAllEntity() {
        return publications;
    }

}
