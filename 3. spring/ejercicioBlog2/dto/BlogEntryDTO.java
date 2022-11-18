package com.mercadolibre.blog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BlogEntryDTO {
    private Long id;
    private String titulo;
    private String nombreAutor;
    @JsonFormat(pattern = "yyyy-MM-dd") // Anotacion de Jackson para cambiar formato
    private LocalDate fechaPublicacion;
}
