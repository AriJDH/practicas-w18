package com.example.frescos.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WarehouseDTO {
    private SectionDTO section;
    private Long productoId;
    private List<BatchForStockDTO> batches;
}
