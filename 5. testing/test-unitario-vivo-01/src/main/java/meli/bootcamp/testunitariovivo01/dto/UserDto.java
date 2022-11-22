package meli.bootcamp.testunitariovivo01.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class UserDto {
    @NotBlank
    private String nombre;
    @Size(max = 15, message = "El nombre no puede tener mas de 15 letras")
    @NotBlank
    private String apellido;
    @Max(value = 99, message = "La edad no puede ser mayor a 99")
    private int edad;
}
