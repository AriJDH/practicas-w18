package com.example.relaciones_tablas.model.claveCompuesta;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "personas")
@IdClass(value = PersonaKey.class)
public class Persona {

    @Id
    private Integer dni;

    @Id
    private Integer numTramite;

    private String nombre;
}
