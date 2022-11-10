package ejercicios.ejerciciodeportistas.entidades;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Persona {

    //Atributos
    private String nombre;
    private String apellido;
    private int edad;
    private String deporte;

}
