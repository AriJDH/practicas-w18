package com.example.SocialMeli2.dto.respose;

import com.example.SocialMeli2.entity.Product;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class ProductDTORes {
    private Integer product_id;
    private String product_name;
    private String type;
    private String brand;
    private String color;
    private String notes;

    public ProductDTORes(Product product) {
        product_id = product.getProduct_id();
        product_name = product.getProduct_name();
        type = product.getType();
        brand = product.getBrand();
        color = product.getColor();
        notes = product.getNotes();
    }
}
