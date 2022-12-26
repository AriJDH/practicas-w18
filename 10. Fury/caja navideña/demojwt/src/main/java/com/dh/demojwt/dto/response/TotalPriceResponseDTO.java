package com.dh.demojwt.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TotalPriceResponseDTO { //US002
    @JsonProperty("total_price")
    private Double totalPrice;
}
