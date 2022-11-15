package com.example.practicablogexcepciones.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradaBlog {

    private long id;
    private String titulo;
    private String autor;
    private Date fechaPublicacion;

}
