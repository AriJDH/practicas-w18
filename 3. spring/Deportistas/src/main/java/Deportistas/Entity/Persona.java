package Deportistas.Entity;

import lombok.*;

import java.util.List;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    private String nombre;
    private String apellido;
    private Integer edad;
    private List<Deporte> deporteList;
}
