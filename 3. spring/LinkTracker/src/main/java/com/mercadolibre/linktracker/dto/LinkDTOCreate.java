package com.mercadolibre.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LinkDTOCreate {
    private Long linkId;
    private String link;
    private String password;
}
