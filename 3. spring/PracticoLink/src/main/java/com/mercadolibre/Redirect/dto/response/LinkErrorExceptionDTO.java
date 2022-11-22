package com.mercadolibre.Redirect.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class LinkErrorExceptionDTO {
    private String message;
    private int status;
}
