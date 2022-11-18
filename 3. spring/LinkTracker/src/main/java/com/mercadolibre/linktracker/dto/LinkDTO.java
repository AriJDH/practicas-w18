package com.mercadolibre.linktracker.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LinkDTO {
    @JsonProperty("id_link")
    private Long linkId;
    @JsonProperty("url")
    private String link;
}
