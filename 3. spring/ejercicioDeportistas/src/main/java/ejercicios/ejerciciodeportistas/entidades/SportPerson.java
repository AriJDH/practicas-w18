package ejercicios.ejerciciodeportistas.entidades;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SportPerson {
    //Atributos
    private String nombre;
    private String apellido;
    private int edad;
    private String deporte;
}
