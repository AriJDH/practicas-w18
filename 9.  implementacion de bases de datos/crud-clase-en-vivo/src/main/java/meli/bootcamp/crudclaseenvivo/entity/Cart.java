package meli.bootcamp.crudclaseenvivo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_id")
    private Long id;
    @OneToMany(mappedBy = "cart", cascade = CascadeType.PERSIST.MERGE)
    private Set<Item> items;
}
