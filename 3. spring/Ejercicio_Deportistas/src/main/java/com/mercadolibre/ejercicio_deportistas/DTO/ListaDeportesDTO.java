package com.mercadolibre.ejercicio_deportistas.DTO;

import com.mercadolibre.ejercicio_deportistas.entity.Deporte;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaDeportesDTO {
    private List<DeportesDTO> deportes = new ArrayList<>();

    public void agregarDeporte(DeportesDTO deporte){
        deportes.add(deporte);
    }

}
