package com.modulospring.deportistas.repositorio;

import com.modulospring.deportistas.entity.Deporte;
import com.modulospring.deportistas.entity.Persona;

import java.util.List;

public interface IRepositorio {
    List<Persona> addListPerson();
    List<Deporte> addListSport();

}
