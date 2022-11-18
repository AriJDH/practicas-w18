package com.example.socialmeli.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {

    private Integer id;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String notes;

}
