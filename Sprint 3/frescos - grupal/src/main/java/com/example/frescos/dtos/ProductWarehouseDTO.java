package com.example.frescos.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductWarehouseDTO {
    @JsonProperty("producto_id")
    private Long productoId;
    private List<WarehouseQuantityDTO> warehouses;
}
