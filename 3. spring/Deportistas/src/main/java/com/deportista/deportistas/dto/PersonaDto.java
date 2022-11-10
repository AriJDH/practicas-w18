package com.deportista.deportistas.dto;

import com.deportista.deportistas.model.Deporte;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonaDto {
    String nombre;
    String apellido;
    List<DeporteDto> deportes=new ArrayList<>();
}
