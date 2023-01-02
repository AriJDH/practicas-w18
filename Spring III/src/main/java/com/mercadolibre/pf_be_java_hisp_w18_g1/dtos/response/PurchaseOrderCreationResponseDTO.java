package com.mercadolibre.pf_be_java_hisp_w18_g1.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrderCreationResponseDTO {
    @JsonProperty("order_number")
    private Long orderNumber;
    @JsonProperty("total_price")
    private Double totalPrice;
}
