package com.example.covid19.repository;

import com.example.covid19.entity.Sintoma;

import java.util.ArrayList;
import java.util.List;

public class SintomasRepo {

    public List<Sintoma> sintomas;

    public SintomasRepo() {
        this.sintomas = new ArrayList<>();

        sintomas.add(new Sintoma(123, "fiebre", 3));
        sintomas.add(new Sintoma(456, "tos", 2));
        sintomas.add(new Sintoma(789, "dolor de cabeza", 2));
        sintomas.add(new Sintoma(147, "mareo", 3));
        sintomas.add(new Sintoma(258, "comvulsion", 5));
        sintomas.add(new Sintoma(369, "perdida de memoria", 5));
    }
}
