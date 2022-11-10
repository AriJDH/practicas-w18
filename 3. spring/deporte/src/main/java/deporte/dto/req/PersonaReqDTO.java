package deporte.dto.req;

import deporte.entity.Deporte;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PersonaReqDTO {

    private String nombre;
    private String apellido;
    private  Integer edad;
    private List<Deporte> deportes;
}
