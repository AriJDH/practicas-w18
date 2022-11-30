package covid19.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    int id;
    String nombre;
    String apellido;
    int edad;
    ArrayList<Integer> sintomasId;

}
