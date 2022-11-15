package com.bootcamp.blog.dto.request;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class BlogDtoRequest {
    private int id;
    private String titulo;
    private String autor;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaPublicacion;
}
