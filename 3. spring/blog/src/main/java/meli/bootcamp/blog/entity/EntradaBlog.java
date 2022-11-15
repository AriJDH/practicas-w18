package meli.bootcamp.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlog {
    private int id;
    private String titulo;
    private String nombreAutor;
    private String fecha;
}
