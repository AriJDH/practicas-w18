package com.mercadolibre.Relations.oneToMany;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //mappedBy para definir el lado de referencia de la relacion
    @OneToMany(mappedBy = "cart")
    private Set<Item> items;

    //para que la relac sea bidireccional tenemos que def el lado de referencia
    //usamos el atributo mappedBy de @OneToMany para esto
    //en mappedBy definimos el nombre del atributo de mapeo de asociacion en el lado del propietario.
}
