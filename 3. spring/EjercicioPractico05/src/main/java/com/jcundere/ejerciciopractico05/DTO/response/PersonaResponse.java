package com.jcundere.ejerciciopractico05.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaResponse {

    private String nombre;
    private String apellido;
    private Integer edad;
    private List<String> nombreSintomaList;

}
