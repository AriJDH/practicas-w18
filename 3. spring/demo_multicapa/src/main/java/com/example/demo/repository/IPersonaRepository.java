package com.example.demo.repository;

import com.example.demo.entity.Persona;

import java.util.List;

public interface IPersonaRepository {
    List<Persona> findAll();
}
