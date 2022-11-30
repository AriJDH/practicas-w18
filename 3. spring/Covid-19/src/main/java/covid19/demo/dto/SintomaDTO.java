package covid19.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SintomaDTO {

    int codigo;
    String nombre;
    String nivel_de_gravedad;


}