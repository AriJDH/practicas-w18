package com.sprint1.be_java_hisp_w18_g03.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductResponseDTO {
    private Integer productId;
    private String productName;
    private String brand;
    private String color;
    private String notes;
}
