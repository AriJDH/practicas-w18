package com.bootcamp.elastic.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

@Getter
@Document(indexName = "literature")
public class Literature {

    @Id
    private String id;
    private String title;
    private String author;
    @JsonProperty("cant_pages")
    private Integer cantPages;
    private String editorial;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Field(type = FieldType.Date)
    @JsonProperty("first_post")
    private LocalDate firstPost;
    
    public void setId(String id) {
        this.id = id;
    }
}
