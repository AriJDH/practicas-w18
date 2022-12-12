package com.jpa.relaciones.model.claveCompuesta;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter @Setter

public class PersonaKey implements Serializable {
    private Integer dni;
    private Integer numTramite;


    //Fundamental sobreescribir los métodos equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonaKey that = (PersonaKey) o;
        return Objects.equals(dni, that.dni) && Objects.equals(numTramite, that.numTramite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, numTramite);
    }
}
