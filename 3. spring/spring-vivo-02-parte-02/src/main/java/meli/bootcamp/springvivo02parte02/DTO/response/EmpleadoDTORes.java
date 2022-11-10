package meli.bootcamp.springvivo02parte02.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
public class EmpleadoDTORes {
    private String nombre;
    private String apellido;
    private String mensaje;
}
