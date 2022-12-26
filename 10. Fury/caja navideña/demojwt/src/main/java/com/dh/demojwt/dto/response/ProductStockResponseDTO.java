package com.dh.demojwt.dto.response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductStockResponseDTO { //US004

    @JsonProperty("product_id")
    private Integer productID;

    @JsonProperty("warehouses")
    private List<WarehouseResponseDTO> warehouses;

}
