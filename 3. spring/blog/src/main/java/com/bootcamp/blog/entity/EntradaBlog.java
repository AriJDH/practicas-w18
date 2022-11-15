package com.bootcamp.blog.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EntradaBlog {
    private int id;
    private String titulo;
    private String autor;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaPublicacion;
}
