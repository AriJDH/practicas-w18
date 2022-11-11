package com.personadeporte.PersonaDeporte.dto.res;

import com.personadeporte.PersonaDeporte.entity.Deporte;

import java.util.List;

public class PersonaResDTO {
    private String nombre;
    private String apellido;
    private List<String> nombreDeporte;

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

    public List<String> getNombreDeporte() {
        return nombreDeporte;
    }

    public void setNombreDeporte(List<String> nombreDeporte) {
        this.nombreDeporte = nombreDeporte;
    }
}
