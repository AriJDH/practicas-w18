package com.jewels.jewels.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RequestJewelDTO {
    Integer code;
    String name;
    String material;
    Double weight;
    String particularity;
    Boolean hasStone;
    Boolean onSale;
}
