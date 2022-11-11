package com.example.demo_calculadora_calorias.dto.response;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
public class PlatoDTOres {
    private Integer cantidadCalorias;
    private List<EstructuraPlatoDtores>  ingredientes;
    private String IngredienteMasCalorias;
}
