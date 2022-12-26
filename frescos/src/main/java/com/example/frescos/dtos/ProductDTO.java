package com.example.frescos.dtos;

import com.example.frescos.enums.SectionCode;
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
