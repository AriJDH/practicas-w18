package com.mercadolibre.Relations.oneToMany;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //muchos items asociados a un carrito
    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    //en una relacion uno a muchos, definimos el lado del propietario en el MUCHOS,
    // y es donde dejamos la clave externa (usamos @JoinColumn para eso).
}
