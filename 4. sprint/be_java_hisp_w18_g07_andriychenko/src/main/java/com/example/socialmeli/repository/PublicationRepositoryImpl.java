package com.example.socialmeli.repository;

import com.example.socialmeli.entity.PublicationEntity;
import com.example.socialmeli.exception.NotFoundException;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PublicationRepositoryImpl implements IPublicationRepository {


    Map<Integer, PublicationEntity> publications = new HashMap<>();

    public PublicationRepositoryImpl() {
        publications.put(1, new PublicationEntity(1, LocalDate.parse("2022-11-16"), 4, 1, 1, 50.));
        publications.put(2, new PublicationEntity(2, LocalDate.parse("2022-11-01"), 6, 2, 10, 30.));
        publications.put(3, new PublicationEntity(3, LocalDate.parse("2022-11-10"), 6, 3, 2, 10.));
    }

    @Override
    public Boolean addPublication(PublicationEntity publicationEntity) {
        PublicationEntity publication = new PublicationEntity(publicationEntity.getId(), publicationEntity.getDate(),publicationEntity.getUserId(), publicationEntity.getProductId(),publicationEntity.getCategory(),publicationEntity.getPrice() );
        publications.put(publicationEntity.getId(), publication);
        return true;
    }

    @Override
    public PublicationEntity getEntityById(Integer id) {
        if (this.publications.get(id) == null){
            throw new NotFoundException("No existe publicacion con ID: " + id);
        }

        return publications.get(id);
    }

    @Override
    public Map<Integer, PublicationEntity> getAllEntity() {
        return publications;
    }

}
