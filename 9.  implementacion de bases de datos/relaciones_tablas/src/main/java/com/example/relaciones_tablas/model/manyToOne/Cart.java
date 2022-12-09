package com.example.relaciones_tablas.model.manyToOne;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(mappedBy = "cart")
    private Set<Item> items;
}
