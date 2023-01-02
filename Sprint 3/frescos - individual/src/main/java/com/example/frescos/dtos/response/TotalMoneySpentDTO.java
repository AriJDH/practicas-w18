package com.example.frescos.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TotalMoneySpentDTO {
    @JsonProperty("total_price")
    private Double totalPrice;
}
