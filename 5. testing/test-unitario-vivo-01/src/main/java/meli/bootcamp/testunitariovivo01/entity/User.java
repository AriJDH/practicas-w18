package meli.bootcamp.testunitariovivo01.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotBlank
    private String nombre;
    @Size(max = 15, message = "El nombre no puede tener mas de 15 letras")
    @NotBlank
    private String apellido;
    @Max(value = 99, message = "La edad no puede ser mayor a 99")
    private int edad;
}
