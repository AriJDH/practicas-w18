package com.example.practicablogexcepciones.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradaBlogDto {
    private long id;
    private String titulo;
    private String autor;
    private Date fechaPublicacion;
}
