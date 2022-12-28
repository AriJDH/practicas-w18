package com.example.frescos.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductWarehouseDTO {
    private Long productoId;
    private List<WarehouseQuantityDTO> warehouses;
}
