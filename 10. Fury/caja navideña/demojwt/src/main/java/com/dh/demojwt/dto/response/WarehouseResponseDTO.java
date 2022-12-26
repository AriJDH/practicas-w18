package com.dh.demojwt.dto.response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseResponseDTO { //US004

    @JsonProperty("warehouse_code")
    private Integer warehouseCode;

    @JsonProperty("total_quantity")
    private Integer totalQuantity;
}
