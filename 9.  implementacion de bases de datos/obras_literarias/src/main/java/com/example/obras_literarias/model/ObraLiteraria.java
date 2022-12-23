package com.example.obras_literarias.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

@Data
@Document(indexName = "literature")
public class ObraLiteraria {
    @Id
    private String    id;
    private String    titulo;
    private String    autor;
    private int   cantPaginas;
    private String    editorial;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Field(type = FieldType.Date)
    private LocalDate primeraPublicacion;
}
