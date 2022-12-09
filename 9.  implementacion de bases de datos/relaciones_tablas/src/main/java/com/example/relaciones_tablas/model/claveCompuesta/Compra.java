package com.example.relaciones_tablas.model.claveCompuesta;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.time.LocalDate;

@Entity
@IdClass(value = CompraKey.class)
public class Compra {

    @Id
    private Integer cliente_id;

    @Id
    private LocalDate fecha;

}
