package com.meli.springmanejoexcepcionesp1vivo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogDto {
    private Integer id;
    private String title;
    private String autor;
    private Date publicationDate;
}
