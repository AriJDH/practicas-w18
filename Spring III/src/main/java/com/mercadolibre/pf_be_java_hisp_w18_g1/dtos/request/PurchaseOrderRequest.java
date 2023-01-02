package com.mercadolibre.pf_be_java_hisp_w18_g1.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.pf_be_java_hisp_w18_g1.dtos.PurchaseOrderDTO;
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
