package com.jpa.joyeria.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int nro_identificatorio;
    String nombre;
    String material;
    Double peso;
    String particularidad;
    Boolean posee_piedr;
    Boolean ventaONo = true;
}

