package com.demomulticapa.demomulticapa.repository;

import com.demomulticapa.demomulticapa.entity.Persona;

import java.util.List;

public interface IPersonaRepository {
    List<Persona> findAll();
}
