package com.example.frescos.dtos.response;

import com.example.frescos.dtos.BatchDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchStockResponse {
    @JsonProperty("batch_stock")
    private List<BatchDTO> batches;
}
