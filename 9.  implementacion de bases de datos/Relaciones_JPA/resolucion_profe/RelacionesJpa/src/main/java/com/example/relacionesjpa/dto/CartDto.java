package com.example.relacionesjpa.dto;

import com.example.relacionesjpa.entity.OneToMany.Item;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CartDto {
    private Long id;
    private Set<ItemDto> items;

}
