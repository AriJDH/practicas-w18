package com.example.melifrescos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Item {
    @Id
    private Long idItem;
    private Integer quantity;
    @ManyToOne(cascade = {CascadeType.MERGE})
    private Product product;
}
