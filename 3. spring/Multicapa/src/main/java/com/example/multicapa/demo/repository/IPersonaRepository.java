package com.example.multicapa.demo.repository;

import com.example.multicapa.demo.entity.Persona;

import java.util.List;

public interface IPersonaRepository {
    List<Persona> findAll();

}
