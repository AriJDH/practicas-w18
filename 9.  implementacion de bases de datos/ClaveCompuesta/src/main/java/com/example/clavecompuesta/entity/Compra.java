package com.example.clavecompuesta.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "compras")
@IdClass( value = CompraKey.class)
public class Compra {
    @Id
    private Integer clienteid;
    @Id
    private LocalDate fecha;
    private String product;
    private Double subTotal;
    private Double impuestos;
    private String direccionEnvio;
}
