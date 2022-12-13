package com.mercadolibre.Relations.oneToOne;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Indica la relacion uno a uno con address
    //cascade -> indica que tipo de propagacion usaremos en la bdd
    //CascadeType.ALL -> indica que se ejecutarán todas las operaciones en cascada
    @OneToOne(cascade = CascadeType.ALL)
    //define el nombre de la columna de la tabla users que mapea a la PK de la tabla address.
    //name -> indica el nombre que va a tener nuestra columna en la bdd
    //referencedColumnName -> indica el nombre del atributo de la otra tabla que queremos relacionar
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
}
