package com.example.clavescompuestas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Compra {
    @EmbeddedId
    private CompraKey compraKey;
    @Column
    private Double monto;
    @Column
    private String descripcion;
}
