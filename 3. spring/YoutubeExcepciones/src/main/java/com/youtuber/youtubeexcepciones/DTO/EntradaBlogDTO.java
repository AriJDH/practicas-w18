package com.youtuber.youtubeexcepciones.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class EntradaBlogDTO {

    private int id;
    private String title;
    private String nameAuthor;
    private Date publicDate;
}
