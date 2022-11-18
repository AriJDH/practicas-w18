package com.multiacapa.starswars.repository;

import com.multiacapa.starswars.entity.Personaje;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPersonajesRepository {
    List<Personaje> findAll();

    List<Personaje> findByName(String name);

}
