package com.example.multicapavivo.repository;

import com.example.multicapavivo.entity.Persona;

import java.util.List;

public interface IPersonaRepository {
    List<Persona> findAll();
}
