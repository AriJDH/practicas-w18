package com.jpa.clavesCompuestas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class CompraKey implements Serializable {
    private Integer clienteId;
    private LocalDate fecha;




    //Fundamental sobreescribir los métodos equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompraKey that = (CompraKey) o;
        return Objects.equals(clienteId, that.clienteId) && Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clienteId, fecha);
    }
}
