package com.example.relaciones_tablas.model.claveCompuesta;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class PersonaKey implements Serializable {

    private Integer dni;

    private Integer numTramite;

}
