package com.example.blogyoutube.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EntradaBlogRes {
    private Integer id;
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;
}
