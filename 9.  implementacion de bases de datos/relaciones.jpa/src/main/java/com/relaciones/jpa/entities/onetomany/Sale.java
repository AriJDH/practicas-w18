package com.relaciones.jpa.entities.onetomany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sales")
public class Sale {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "saleId")
    private List<SaleDetails> list;

}

