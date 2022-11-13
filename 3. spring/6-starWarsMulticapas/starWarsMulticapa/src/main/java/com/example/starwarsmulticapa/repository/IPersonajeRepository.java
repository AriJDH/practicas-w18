package com.example.starwarsmulticapa.repository;

import com.example.starwarsmulticapa.entity.Personaje;

import java.util.List;

public interface IPersonajeRepository {
 List<Personaje> listSelectPersonajes(String name);
}
