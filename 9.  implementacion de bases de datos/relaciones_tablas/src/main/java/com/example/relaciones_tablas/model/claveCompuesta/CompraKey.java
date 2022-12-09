package com.example.relaciones_tablas.model.claveCompuesta;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@EqualsAndHashCode
public class CompraKey implements Serializable {

    private Integer cliente_id;

    private LocalDate fecha;
}
