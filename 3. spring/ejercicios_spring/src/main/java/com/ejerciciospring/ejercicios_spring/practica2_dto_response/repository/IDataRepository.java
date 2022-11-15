package com.ejerciciospring.ejercicios_spring.practica2_dto_response.repository;

import java.util.List;

public interface IDataRepository <T> {

    T crear(T objeto);

    List<T> consultar();

    T consultarPorNombre(String nombre);
}
