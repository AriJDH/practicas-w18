package com.example.frescos.dtos.request;

import com.example.frescos.dtos.PurchaseOrderDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PurchaseOrderRequest {
    @JsonProperty("purchase_order")
    private PurchaseOrderDTO purchaseOrderDTO;
}
