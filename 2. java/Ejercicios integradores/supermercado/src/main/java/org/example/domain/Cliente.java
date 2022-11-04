package org.example.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public @Data class Cliente {
    @EqualsAndHashCode.Include
    private int dni;
    @EqualsAndHashCode.Include
    private String nombre;
    @EqualsAndHashCode.Include
    private String apellido;

    public Cliente(int dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String toString(){
        return "DNI: "+ this.dni + ". Nombre: "+ this.nombre + ". Apellido: "+ this.apellido+".";
    }


}
