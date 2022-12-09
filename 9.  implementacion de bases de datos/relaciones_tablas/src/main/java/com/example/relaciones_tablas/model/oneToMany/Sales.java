package com.example.relaciones_tablas.model.oneToMany;

import javax.persistence.*;
import java.util.List;

@Entity
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "sale_id")
    private List<SaleDetails> saleDetails;
}
