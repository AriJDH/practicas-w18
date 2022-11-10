package com.ejerciciospring.ejercicios_spring.repository;

import java.util.List;

public interface IRepository <T> {

    void crear(T entidad);

    List<T> consultarEntidades();

    T consultarEntidadPorNombre(String nombre);

}
