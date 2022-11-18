package com.mercadolibre.ejercicio_deportistas.DTO;

import com.mercadolibre.ejercicio_deportistas.entity.Deporte;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeportesDTO {
    private String nombre;
    private String nivel;
}
