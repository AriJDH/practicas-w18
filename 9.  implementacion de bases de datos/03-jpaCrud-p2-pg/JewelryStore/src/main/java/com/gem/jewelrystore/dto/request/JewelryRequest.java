package com.gem.jewelrystore.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class JewelryRequest {
    private String name;
    private String material;
    private Integer weightGrams;
    private String details;
    private Boolean hasGemstone;
    private Boolean forSale;
}
