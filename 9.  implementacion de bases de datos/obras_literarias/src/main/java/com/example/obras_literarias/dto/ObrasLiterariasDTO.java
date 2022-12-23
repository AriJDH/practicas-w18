package com.example.obras_literarias.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObrasLiterariasDTO {
    private String    id;
    private String    titulo;
    private String    autor;
    private int   cantPaginas;
    private String    editorial;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate primeraPublicacion;
}
