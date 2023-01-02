package com.mercadolibre.pf_be_java_hisp_w18_g1.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WarehouseQuantityDTO {
    @JsonProperty("warehouse_code")
    private Long warehouseCode;
    @JsonProperty("total_quantity")
    private Integer totalQuantity;
}
