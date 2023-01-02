package com.mercadolibre.pf_be_java_hisp_w18_g1.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NotStockDTO {
    private String message;
    private Long productId;
}
