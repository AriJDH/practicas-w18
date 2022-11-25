package com.jcundere.ejerciciopractico09.repository;

import com.jcundere.ejerciciopractico09.entity.LinkEntity;
import com.jcundere.ejerciciopractico09.exception.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepositoryImpl implements ILinkRepository {


    private List<LinkEntity> linkList = new ArrayList<>();

    @Override
    public LinkEntity createEntity(LinkEntity entity) {

        linkList.add(entity);
        return entity;
    }

    @Override
    public LinkEntity getEntityById(Integer id) {


        return linkList.stream()
                .filter(entity -> entity.getId().equals(id))
                .findFirst().orElseThrow(() -> new NotFoundException("No se encuentró el Link solicitado !"));
    }

}
