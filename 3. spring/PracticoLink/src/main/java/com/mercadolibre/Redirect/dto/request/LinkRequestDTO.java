package com.mercadolibre.Redirect.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class LinkRequestDTO {
    private Integer id;
    private String url;
    private String password;
}
