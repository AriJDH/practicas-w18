package com.dh.be_java_hisp_w18_g10.dto.require;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTOreq {
    private int product_id;
    private String product_name;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
