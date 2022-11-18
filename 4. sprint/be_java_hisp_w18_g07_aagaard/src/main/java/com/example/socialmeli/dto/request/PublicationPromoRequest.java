package com.example.socialmeli.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicationPromoRequest extends PublicationRequest {
    @JsonProperty("has_promo")
    private Boolean hasPromo;
    private Double discount;
}
