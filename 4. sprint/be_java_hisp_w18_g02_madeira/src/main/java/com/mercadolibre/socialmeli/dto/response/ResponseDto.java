package com.mercadolibre.socialmeli.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseDto {
    private String message;
    private int status;
}