package com.jpa.relaciones.model.oneToManyUnidireccional;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sales")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

/*  Relaciones 1 a n ->  n (collections)
    Relación unidireccional: En éste caso para encontrar un detalle de venta, vamos a tener que entrar primero a la venta a la cual pertenece ese detalle*/
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "sale_id") //FK -> A nivel BD la FK va del lado de la n, JPA lo transforma y lo coloca en la tabla de sale_details, pero en el código indicamos la relación desde el lado del 1 (Sale -> una venta va a tener varios detalles de venta)
    private List<SaleDetails> list;

}
