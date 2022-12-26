package com.dh.demojwt.dto.request;


import com.dh.demojwt.dto.response.ProductQuantityResponseDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PurchasesRequestDTO { //US002

    private LocalDate date;

    @JsonProperty("buyer_id")
    private Integer buyerId;
    
    @JsonProperty("order_status")
    private OrderStatusRequestDTO orderStatus;

    private List<ProductQuantityResponseDTO> products;

}
