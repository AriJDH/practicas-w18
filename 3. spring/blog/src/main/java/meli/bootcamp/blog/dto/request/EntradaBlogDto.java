package meli.bootcamp.blog.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EntradaBlogDto {
    private int id;
    private String titulo;
    private String nombreAutor;
    private String fecha;
}
