package com.example.blog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntradaBlog {
    private Integer id;
    private String nombre;
    private String autor;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaPublicacion;
}
