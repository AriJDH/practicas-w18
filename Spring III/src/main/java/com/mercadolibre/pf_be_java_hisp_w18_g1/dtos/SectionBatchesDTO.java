package com.mercadolibre.pf_be_java_hisp_w18_g1.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.pf_be_java_hisp_w18_g1.enums.SectionCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SectionBatchesDTO {
    @JsonProperty("section_code")
    private SectionCode sectionCode;
    @JsonProperty("products_stock")
    private List<ProductStockDTO> productsStock;

}
