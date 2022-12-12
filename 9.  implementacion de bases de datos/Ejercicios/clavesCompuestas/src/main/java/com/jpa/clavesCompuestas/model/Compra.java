package com.jpa.clavesCompuestas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "compras")
@IdClass(value = CompraKey.class) //Para indicar que tendremos una clave compuesta con la clase que pasamos por parámetro
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Compra {

    //En las claves compuestas, cada atributo tiene que tener su annotations @Id
    @Id
    private Integer clienteId;
    @Id
    private LocalDate fecha;

    private Integer total;
    private String item;


    public Compra(CompraKey key, int total, String item) {
        this.clienteId = key.getClienteId();
        this.fecha = key.getFecha();
        this.total = total;
        this.item = item;
    }
}
