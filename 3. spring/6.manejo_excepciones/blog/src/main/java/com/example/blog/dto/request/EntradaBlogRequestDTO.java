package com.example.blog.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EntradaBlogRequestDTO {
    private Long id;
    private String titulo;
    private String nombreAutor;
    private LocalDate fechaPublicacion;
}
