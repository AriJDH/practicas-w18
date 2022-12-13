package com.bootcamp.elastic.entity;

import com.bootcamp.elastic.entity.models.Address;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.core.index.AliasAction;

import java.time.LocalDate;
import java.util.List;

@Data
@Document(indexName = "employees")
public class Employee {
    @Id
    String id;

    @Field(type = FieldType.Keyword)
    String name;
    String description;
    int experiences;

//    @Field(type = FieldType.Nested)
//    List<Address> address;

//    @Field(type = FieldType.Date) // @Column en JPA
//    @JsonFormat(pattern = "dd/MM/yyyy") // para ambos casos
//    LocalDate date;
}