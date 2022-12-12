package com.example.obrasliterarias.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "obra")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Obra {
    @Id
    private String id;
    private String titulo;
    private String nombreAutor;
    private Integer cantidadPaginas;
    private String editorial;
    private Integer anioPrimerPublicacion;
}
