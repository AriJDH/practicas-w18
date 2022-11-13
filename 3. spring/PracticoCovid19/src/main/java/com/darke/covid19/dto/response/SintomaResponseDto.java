package com.darke.covid19.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SintomaResponseDto {
    private Integer codigo;
    private String nombre;
    private String nivel_de_gravedad;
}
