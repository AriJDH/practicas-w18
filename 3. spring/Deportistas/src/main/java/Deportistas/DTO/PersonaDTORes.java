package Deportistas.DTO;

import lombok.*;

import java.util.List;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTORes {
    private String nombre;
    private String apellido;
    private List<String> deporte;
    private String mensaje;
}

