package com.example.blog.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EntradaBlogDTOReq {
    private Integer id;
    private String nombre;
    private String autor;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaPublicacion;
}
