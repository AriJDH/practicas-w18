package com.mercadolibre.pf_be_java_hisp_w18_g1.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SectionDTO {
    @JsonProperty("section_code")
    private Integer sectionCode;
    @JsonProperty("warehouse_code")
    private Long warehouseCode;
}
