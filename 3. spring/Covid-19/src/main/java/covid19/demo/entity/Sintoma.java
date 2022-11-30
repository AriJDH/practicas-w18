package covid19.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sintoma {

    int codigo;
    String nombre;
    String nivel_de_gravedad;
}
