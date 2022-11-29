package com.meli.be_java_hisp_w18_g01.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private long product_id;
    private String product_name;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
