package com.hql.hql.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Data
@Getter
@Setter
@Entity
@Table(name = "vehiculo")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private int añoFabricacion;
    private int cantRuedas;

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL)
    private List<Siniestro> siniestros;
}
