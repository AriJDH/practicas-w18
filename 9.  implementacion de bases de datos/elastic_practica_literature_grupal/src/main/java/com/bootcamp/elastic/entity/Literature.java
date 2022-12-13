package com.bootcamp.elastic.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

@Data
@Document(indexName = "literature")
public class Literature {

    @Id
    private String id;

    private String name;
    private String title;
    private String author;

    private String editorial;

    @JsonProperty("cant_pages")
    private int pages;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Field(type = FieldType.Date)
    @JsonProperty("first_post")
    private LocalDate firstPost;
}
