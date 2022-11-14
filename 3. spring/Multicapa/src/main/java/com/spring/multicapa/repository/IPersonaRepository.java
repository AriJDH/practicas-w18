package com.spring.multicapa.repository;

import com.spring.multicapa.entity.Persona;

import java.util.List;

public interface IPersonaRepository {
    List<Persona> findAll();
}
