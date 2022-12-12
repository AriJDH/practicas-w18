package com.jpa.relaciones.model.oneToManyBidireccional;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "items")
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @ManyToOne //Asociada con la variable de clase cart. Muchos ítems asociados a un carro.
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;
}
