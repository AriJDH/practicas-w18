package com.example.claveCompuesta.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "compras")
//@IdClass(value = CompraKey.class )
public class Compra {
    /*@Id
    private Integer clienteId;
    @Id
    private LocalDate fecha;*/
    @EmbeddedId
    private CompraKey compraKey;
    /* Otra manera de definir llaves primarías compuestas es con la Enumeración @EmbeddedId,
    la cual permite marcar una clase como ID. A diferencia de @IdClass, este método no requiere definir
    los atriburos de la llave primaria en la entidad, sino que solo hace falta agregar como atributo
    la clase que contiene todos los campos.
    Una diferencia que tiene este método con respecto al @IdClass, es qué es necesario que la clase ID
    esta anotada a nivel de clase con la anotación @Embeddable. Esto le dice a JPA que esta clase se puede
    embeber dentro de otra.*/
    private Double precio;
    private String formaDePago;
}
