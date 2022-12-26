package com.example.frescos.entity;

import com.example.frescos.enums.SectionCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @Enumerated(EnumType.ORDINAL)
    private SectionCode sectionCode;
    private Double price;
    private String category;

    public Product(String description, SectionCode sectionCode, Double price) {
        this.description = description;
        this.sectionCode = sectionCode;
        this.price = price;
    }
}
