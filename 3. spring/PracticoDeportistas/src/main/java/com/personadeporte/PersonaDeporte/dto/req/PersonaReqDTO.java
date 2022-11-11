package com.personadeporte.PersonaDeporte.dto.req;

import com.personadeporte.PersonaDeporte.entity.Deporte;

import java.util.List;

public class PersonaReqDTO {
    private String nombre;
    private String apellido;
    private Integer edad;
    private List<Deporte> deportes;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public List<Deporte> getDeportes() {
        return deportes;
    }

    public void setDeportes(List<Deporte> deportes) {
        this.deportes = deportes;
    }
}
