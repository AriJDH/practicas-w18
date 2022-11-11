package com.example.calorias.dto.response;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PlatoDtoResponse {

    private List<StructPlatoResponse> ingredientesPlato;
    private int totalCalorias;
    private String mayorCantidadCalorias;

}
