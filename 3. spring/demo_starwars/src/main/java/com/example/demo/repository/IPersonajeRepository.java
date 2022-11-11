package com.example.demo.repository;

import com.example.demo.entity.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> findAll();
    void loadList();
}
