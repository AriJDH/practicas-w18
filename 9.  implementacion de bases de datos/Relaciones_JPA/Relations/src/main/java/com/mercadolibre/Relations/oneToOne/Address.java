package com.mercadolibre.Relations.oneToOne;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //indica la relacion uno a uno con user
    // mappedBy -> indica que la variable "address" del lado user es quien establece la relacion.
    @OneToOne(mappedBy = "address")
    private User user;
}
