package com.jcundere.ejerciciopractico05.repository;

import com.jcundere.ejerciciopractico05.entity.SintomaEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SintomaRepositoryImpl implements CRUDRepository {

        List<SintomaEntity> sintomaEntityList = new ArrayList<>();


        public SintomaRepositoryImpl(){

                sintomaEntityList.add(new SintomaEntity("S1", "Fiebre", "Intermedia"));
                sintomaEntityList.add(new SintomaEntity("S2", "Tos", "Baja"));
                sintomaEntityList.add(new SintomaEntity("S3", "Cansancio", "Intermedia"));
                sintomaEntityList.add(new SintomaEntity("S4", "Perdida del Gusto u Olfato", "Baja"));
                sintomaEntityList.add(new SintomaEntity("S5", "Dolor de Garganta", "Baja"));
                sintomaEntityList.add(new SintomaEntity("S6", "Dolor de Pecho", "Alta"));
                sintomaEntityList.add(new SintomaEntity("S7", "Dificultad para Respirar", "Alta"));
                sintomaEntityList.add(new SintomaEntity("S8", "Perdida de Movilidad", "Intermedia"));

        }

        @Override
        public void save(Object objeto) {

        }

        @Override
        public Optional<SintomaEntity> buscar(String name) {
                for (SintomaEntity elemento : sintomaEntityList) {
                        if (elemento.getNombre().equalsIgnoreCase(name)) {
                                return Optional.of(elemento);
                        }
                }
                return Optional.empty();
        }

        @Override
        public List traeTodos() {
                return sintomaEntityList;
        }

}
