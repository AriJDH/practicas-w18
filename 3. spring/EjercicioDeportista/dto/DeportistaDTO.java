package com.mercadolibre.deportistas.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeportistaDTO {
    private String nombreCompleto;
    private List<String> deportes;
}
