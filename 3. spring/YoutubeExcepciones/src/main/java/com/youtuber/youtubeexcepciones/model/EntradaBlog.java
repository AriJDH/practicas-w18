package com.youtuber.youtubeexcepciones.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlog {

    private int id;
    private String title;
    private String nameAuthor;
    private Date publicDate;

}
