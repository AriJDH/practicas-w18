package deporte.dto.resp;

import deporte.entity.Deporte;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class PersonaDTO {
    private String nombre;
    private String apellido;
    private List<String> nombreDeporte;




}
