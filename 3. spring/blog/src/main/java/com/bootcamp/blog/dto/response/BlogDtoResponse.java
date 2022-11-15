package com.bootcamp.blog.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class BlogDtoResponse {
    private int id;
    private String titulo;
    private String autor;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaPublicacion;
}
