package com.example.frescos.dtos;

import com.example.frescos.enums.SectionCode;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {
    private String description;
    @JsonProperty("section_code")
    private SectionCode sectionCode;
    private Double price;
}
