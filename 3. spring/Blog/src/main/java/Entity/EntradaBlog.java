package Entity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntradaBlog {
    private int id;
    private String titulo;
    private String autor;
    private String fechaPublicacion;
}
