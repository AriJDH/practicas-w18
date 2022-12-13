package com.mercadolibre.elasticsearch.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mercadolibre.elasticsearch.entity.models.Address;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

@Data
@Document(indexName = "employees")
public class Employee {
    @Id
    private String id;

    private String name;
    private String description;
    private String experience;

    @Field(type = FieldType.Nested)
    private Address address;

    /*@Field(type = FieldType.Date)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;*/
}
