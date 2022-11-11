package com.jcundere.ejerciciopractico04.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeporteRequest {

    private String nombre;
    private String nivel;

}
