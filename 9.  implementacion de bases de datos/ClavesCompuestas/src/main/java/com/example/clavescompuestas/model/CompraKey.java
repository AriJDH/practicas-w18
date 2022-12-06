package com.example.clavescompuestas.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CompraKey implements Serializable {
    private Long clienteId;
    private LocalDate fecha;

}
