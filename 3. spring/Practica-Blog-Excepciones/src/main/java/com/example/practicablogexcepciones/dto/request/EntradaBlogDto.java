package com.example.practicablogexcepciones.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradaBlogDto {
    private long id;
    private String titulo;
    private String autor;
    private SimpleDateFormat fechaPublicacion;
}
