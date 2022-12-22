package com.example.clavecompuesta.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "compras")
@IdClass(value = CompraKey.class)
public class CompraEntity {

    @Id
    private Integer clientId;

    @Id
    private LocalDate fecha;

    private String articulo;

    private Integer cantidad;

}
