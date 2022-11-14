package com.bootcamp.covid19.repository;

import com.bootcamp.covid19.entity.Persona;
import com.bootcamp.covid19.entity.Sintoma;

import java.util.List;
import java.util.Map;

public interface ICovid19Repository {
    List<Persona> listaPersona();
    List<Sintoma> listaSintomas();

}
