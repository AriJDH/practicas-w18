package meli.bootcamp.empleados.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Setter
@Getter
@AllArgsConstructor
@Document(indexName = "empleados")
public class Empleado {
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private String descripcion;
    private Integer edad;
    private String ciudad;
}
