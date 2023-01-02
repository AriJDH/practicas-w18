package com.mercadolibre.pf_be_java_hisp_w18_g1.entity;

import com.mercadolibre.pf_be_java_hisp_w18_g1.enums.SectionCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode
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

    public Product(String description, SectionCode sectionCode, Double price, String category) {
        this.description = description;
        this.sectionCode = sectionCode;
        this.price = price;
        this.category = category;
    }
}
