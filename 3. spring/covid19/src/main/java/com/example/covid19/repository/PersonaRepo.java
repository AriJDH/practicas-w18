package com.example.covid19.repository;

import com.example.covid19.entity.Sintoma;

import java.util.ArrayList;
import java.util.List;

public class PersonaRepo {

    public List<Sintoma> personas;

    public PersonaRepo() {
        this.personas = new ArrayList<>();

    }
}
