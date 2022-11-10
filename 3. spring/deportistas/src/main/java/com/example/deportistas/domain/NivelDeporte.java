package com.example.deportistas.domain;

public enum NivelDeporte {
    ALTO("ALTO"),
    MEDIO("MEDIO"),
    BAJO("BAJO");
    private String code;
    NivelDeporte(String code){
        this.code = code;
    }
}
