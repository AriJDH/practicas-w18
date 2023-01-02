package com.mercadolibre.pf_be_java_hisp_w18_g1.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderStatusDTO {
    @JsonProperty("status_code")
    private String statusCode;
}
