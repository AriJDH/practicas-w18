package com.example.covid.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum NivelDeGravedad {
    GRAVE("GRAVE"),
    MEDIO("MEDIO"),
    LEVE("LEVE");
    private String code;
    NivelDeGravedad(String code){
        this.code=code;
    }

    String getCode(){
        return this.code;
    }

    @JsonCreator
    public static NivelDeGravedad getNivelDeGravedaFromCode(String value) {

        for (NivelDeGravedad nivel : NivelDeGravedad.values()) {

            if (nivel.getCode().equals(value)) {

                return nivel;
            }
        }

        throw new RuntimeException("El nivel de gravedad ingresado no existe.");
    }

}
