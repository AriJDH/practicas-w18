package meli.bootcamp.deportistas.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import meli.bootcamp.deportistas.entities.Deporte;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class DeporteDTORes {
    private String nombre;
    private String nivel;
}
