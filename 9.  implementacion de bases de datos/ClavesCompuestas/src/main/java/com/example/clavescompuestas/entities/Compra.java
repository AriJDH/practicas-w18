package com.example.clavescompuestas.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "compras")
@IdClass(value = CompraKey.class)
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long clienteId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    LocalDate fecha;
    String producto;
    Double precio;
}
