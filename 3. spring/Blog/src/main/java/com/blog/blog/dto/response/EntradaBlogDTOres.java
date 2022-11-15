package com.blog.blog.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EntradaBlogDTOres {

    private Long id;
    private String tituloBlog;
    private String nombreAutor;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaPublicacion;
}