package com.mercadolibre.pf_be_java_hisp_w18_g1.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.pf_be_java_hisp_w18_g1.dtos.InboundOrderDTO;
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
