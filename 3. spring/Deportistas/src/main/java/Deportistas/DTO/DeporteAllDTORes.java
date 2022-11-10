package Deportistas.DTO;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DeporteAllDTORes {
    private String nombre;
    private String nivel;
    private String mensaje;
}
