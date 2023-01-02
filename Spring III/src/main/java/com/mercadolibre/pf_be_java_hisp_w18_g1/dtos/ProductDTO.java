package com.mercadolibre.pf_be_java_hisp_w18_g1.dtos;

import com.mercadolibre.pf_be_java_hisp_w18_g1.enums.SectionCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {
    private String description;
    private SectionCode sectionCode;
    private Double price;
}
