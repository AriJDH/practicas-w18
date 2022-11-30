package com.example.socialmeli2.repository;

import com.example.socialmeli2.entity.PublicationEntity;
import com.example.socialmeli2.exception.NotFoundException;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PublicationRepositoryImpl implements IPublicationRepository {

    PublicationRepositoryImpl() {
        PublicationEntity publication1 = new PublicationEntity
                (1, LocalDate.of(2022, 11, 15), 2, 1, 1, 99.99);
        PublicationEntity publication2 = new PublicationEntity
                (2, LocalDate.of(2022, 11, 16), 2, 2, 1, 199.99);
        PublicationEntity publication3 = new PublicationEntity
                (3, LocalDate.of(2022, 9, 23), 2, 3, 1, 299.99);
        this.addEntity(publication1);
        this.addEntity(publication2);
        this.addEntity(publication3);
    }

    private Map<Integer, PublicationEntity> publications = new HashMap<>();
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
            throw new NotFoundException("No existe publicacion con ID: " + publicationId);
        }

        return publications.get(publicationId);
    }

    @Override
    public Map<Integer, PublicationEntity> getAllEntity() {
        return publications;
    }

}
