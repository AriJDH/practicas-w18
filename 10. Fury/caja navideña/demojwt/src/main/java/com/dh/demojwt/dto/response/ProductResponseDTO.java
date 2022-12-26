package com.dh.demojwt.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {

    @JsonProperty("section")
    private SectionResponseDTO section;

    @JsonProperty("product_id")
    private Integer id;

    @JsonProperty("batch_stock")
    private List<BatchStockQuantityResponseDTO> batchStockQuantityResponseDTO;



}
