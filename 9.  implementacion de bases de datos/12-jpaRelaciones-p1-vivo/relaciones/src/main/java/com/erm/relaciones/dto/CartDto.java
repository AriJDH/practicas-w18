package com.erm.relaciones.dto;

import lombok.Data;

import java.util.Set;

@Data
public class CartDto {
    private Long id;
    private Set<ItemListDto> items;
}
