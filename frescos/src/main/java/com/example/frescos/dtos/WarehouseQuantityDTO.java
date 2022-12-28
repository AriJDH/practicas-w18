package com.example.frescos.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WarehouseQuantityDTO {
    private Long warehouseCode;
    private Integer totalQuantity;
}
