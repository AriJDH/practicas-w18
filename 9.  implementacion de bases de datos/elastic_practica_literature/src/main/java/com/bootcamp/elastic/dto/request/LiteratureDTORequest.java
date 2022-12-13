package com.bootcamp.elastic.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

public class LiteratureDTORequest {
    @JsonProperty("title")
    private String title;
    @JsonProperty("author")
    private String author;

    @JsonProperty("cant_pages")
    private int cantPages;

    @JsonProperty("editorial")
    private String editorial;


    @JsonFormat(pattern = "dd/MM/yyyy")
    @Field(type = FieldType.Date)
    @JsonProperty("first_post")
    private LocalDate firstPost;
}
