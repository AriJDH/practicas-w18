package com.example.covid.repositories;

import com.example.covid.domain.Sintoma;

import java.util.Optional;

public class SintomaRepository extends ListRepository<Sintoma>{
    public Optional<Sintoma> findSintomaByName(String name){
        return super.list.stream().filter(s->s.getNombre().equals(name)).findFirst();
    }
}
