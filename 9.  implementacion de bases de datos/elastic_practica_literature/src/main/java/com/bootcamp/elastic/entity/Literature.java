package com.bootcamp.elastic.entity;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

@Data
@Document(indexName = "books")
public class Literature {
    private String title;
    private String author;
    @JsonAlias(value = "cant_pages")
    private int cantPages;
    private String editorial;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Field(type = FieldType.Date)
    @JsonProperty("first_post")
    private LocalDate firstPost;
}
