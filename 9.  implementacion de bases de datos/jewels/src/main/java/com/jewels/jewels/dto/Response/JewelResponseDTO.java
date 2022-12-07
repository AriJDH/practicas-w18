package com.jewels.jewels.dto.Response;

import com.jewels.jewels.model.Jewel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public class JewelResponseDTO {
    private Long id;

    private Integer code;
    private String name;
    private String material;
    private String weight;
    private String particularity;

    private Boolean hasStone;

    private Boolean onSale;
}
