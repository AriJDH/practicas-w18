package com.jcundere.ejerciciopractico09.repository;

import com.jcundere.ejerciciopractico09.entity.LinkEntity;

public interface ILinkRepository {

    LinkEntity createEntity (LinkEntity entity);

    LinkEntity getEntityById (Integer id);

}
