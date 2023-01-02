package com.example.frescos.dtos.request;

import com.example.frescos.dtos.InboundOrderDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InboundOrderRequest {
    @JsonProperty("inbound_order")
    private InboundOrderDTO inboundOrder;
}
