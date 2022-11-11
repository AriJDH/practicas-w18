package com.ejerciciospring.ejercicios_spring.practica_arquitectura_multicapa_p1_vivo.repository;

import java.util.List;

public interface IRepository <T> {

        List<T> consultarEntidadPorNombre(String nombre);
}
