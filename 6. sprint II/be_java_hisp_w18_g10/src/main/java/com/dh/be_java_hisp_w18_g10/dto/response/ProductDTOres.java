package com.dh.be_java_hisp_w18_g10.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTOres {
    private int product_id;
    private String product_name;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
