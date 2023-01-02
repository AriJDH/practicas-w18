package com.example.frescos.dtos.response;

import com.example.frescos.dtos.PurchaseOrderDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrdersResponseDTO {
    @JsonProperty("purchase_orders")
    private List<PurchaseOrderDTO> purchaseOrders;
}
