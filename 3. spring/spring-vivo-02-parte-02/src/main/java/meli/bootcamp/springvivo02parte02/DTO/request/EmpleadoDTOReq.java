package meli.bootcamp.springvivo02parte02.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
public class EmpleadoDTOReq {
    private String nombre;
    private String apellido;
}
