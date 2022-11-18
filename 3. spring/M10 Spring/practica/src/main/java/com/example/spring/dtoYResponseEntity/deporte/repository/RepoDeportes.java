package com.example.spring.dtoYResponseEntity.deporte.repository;

import com.example.spring.dtoYResponseEntity.deporte.entity.Deporte;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public abstract class RepoDeportes {
    private static ArrayList<Deporte> deportes = new ArrayList<Deporte>();

    static {
        deportes.add(new Deporte("futbol", "fácil"));
        deportes.add(new Deporte("basket", "medio"));
        deportes.add(new Deporte("hockey", "difícil"));
    }

    public static ArrayList<Deporte> getDeportes() {
        return deportes;
    }
}
