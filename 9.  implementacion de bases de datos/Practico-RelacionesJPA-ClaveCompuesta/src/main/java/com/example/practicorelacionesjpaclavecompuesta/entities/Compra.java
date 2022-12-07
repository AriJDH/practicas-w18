package com.example.practicorelacionesjpaclavecompuesta.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "compras")
@IdClass(value = CompraKey.class)
public class Compra {
    @Id
    private Long clienteId;
    @Id
    private Long fecha;
}
