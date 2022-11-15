package com.blog.blog.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntradaBlogDTOreq {

    private Long id;
    private String tituloBlog;
    private String nombreAutor;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaPublicacion;
}
