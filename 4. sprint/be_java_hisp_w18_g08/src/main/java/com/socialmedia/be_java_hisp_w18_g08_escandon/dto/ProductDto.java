package com.socialmedia.be_java_hisp_w18_g08_escandon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
    private Integer product_id;
    private String product_name;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
