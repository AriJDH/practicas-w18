package com.example.blog.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlogResponseDTO {
    private String titulo;
    private String nombreAutor;
    private LocalDate fechaPublicacion;
}

