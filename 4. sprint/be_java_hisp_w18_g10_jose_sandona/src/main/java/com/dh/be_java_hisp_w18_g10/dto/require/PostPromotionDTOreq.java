package com.dh.be_java_hisp_w18_g10.dto.require;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostPromotionDTOreq extends PostDTOreq{

    @JsonProperty("has_promo")
    private boolean hasPromo;
    private double discount;
}
