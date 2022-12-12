package com.jpa.relaciones.model.oneToManyBidireccional;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cart")
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "cart")  //"cart" nombre del atributo que mapea la relación del lado n en Item, mappedBy se utiliza para definir el lado de referencia de la relación.
    private Set<Item> items;

}
