package com.dh.demojwt.dto.response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductQuantityResponseDTO { // US0002
    @JsonProperty("product_id")
    private Integer productId;

    private Integer quantity;
}
