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
    private String    id;
    @Field(type = FieldType.Keyword)
    private String    title;
    private String    author;
    private Integer   cantPages;
    @Field(type = FieldType.Text)
    private String    editorial;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Field(type = FieldType.Date)
    @JsonProperty("first_post")
    private LocalDate firstPost;
}
