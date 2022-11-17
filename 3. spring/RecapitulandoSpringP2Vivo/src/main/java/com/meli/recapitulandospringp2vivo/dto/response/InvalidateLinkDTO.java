package com.meli.recapitulandospringp2vivo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvalidateLinkDTO {
    private Integer id;
    private String link;
    private String message;
}
