package com.example.Multicapa.repository;

import com.example.Multicapa.entity.Persona;

import java.util.List;

public interface IPersonaRepository {
    List<Persona> findAll();
}
