package com.darke.covid19.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SintomaRequestDto {
    private Integer codigo;
    private String nombre;
    private String nivel_de_gravedad;
}
