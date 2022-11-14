package com.example.starwars.repository;

import java.util.List;

public interface IRepository <T> {

        List<T> consultarEntidadPorNombre(String nombre);
}
