package ejercicios.ejerciciodeportistas.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SportPersonDTOResponse {
    private String nombre;
    private String apellido;
    private int edad;
    private String deporte;
}
