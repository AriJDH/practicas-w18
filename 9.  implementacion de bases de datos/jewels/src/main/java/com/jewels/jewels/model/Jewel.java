package com.jewels.jewels.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name="jewels")
@AllArgsConstructor
@NoArgsConstructor
public class Jewel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @Column(unique = true)
    Integer code;
    String name;
    String material;
    Double weight;
    String particularity;
    @Column(name="has_stone")
    Boolean hasStone;
    @Column(name="on_sale")
    Boolean onSale;
}
