package com.example.socialmeli.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public class PublicationPromoRequest extends PublicationRequest{
    @JsonProperty("has_promo")
    private Boolean hasPromo;
    private Double discount;
}
