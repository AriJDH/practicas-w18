package com.mercadolibre.pf_be_java_hisp_w18_g1.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.pf_be_java_hisp_w18_g1.dtos.BatchDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchStockResponseDTO {
    @JsonProperty("batch_stock")
    private List<BatchDTO> batches;
}
