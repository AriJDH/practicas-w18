package ejercicios.ejerciciodeportistas.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

public class PersonaDTOResponse {

    private String nombre;
    private String apellido;
    private String deporte;

}
