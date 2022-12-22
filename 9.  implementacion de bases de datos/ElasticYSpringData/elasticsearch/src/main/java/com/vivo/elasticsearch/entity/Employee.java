package com.vivo.elasticsearch.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vivo.elasticsearch.entity.models.Address;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;
import java.util.List;

@Data
@Document(indexName = "employess")
public class Employee {
    @Id
    private String id;

    @Field(type = FieldType.Keyword) //con ésto no se tokeniza la palabra y la busca exactamente
    private String name;
    private String description;
    private String experience;

    @Field(type = FieldType.Nested)
    List<Address> addresses;

    /*@Field(type = FieldType.Date) // @Column en JPA
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;*/

    // @Field(type = FieldType.Date, format = {}, pattern = "uuuu-MM-dd")
}
