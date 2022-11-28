package com.bootcamp.be_java_hisp_w18_g06.dto.response;

import lombok.Getter;

@Getter
public class ProductDTO {
    private Integer product_id;
    private String product_name;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
