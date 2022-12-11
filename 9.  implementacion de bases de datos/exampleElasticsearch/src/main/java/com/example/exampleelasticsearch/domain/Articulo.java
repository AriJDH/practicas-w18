package com.example.exampleelasticsearch.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "blog")
public class Articulo {
    @Id
    private String id;

    private String titulo;

    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Autor> autores;
}
