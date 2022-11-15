package com.meli.springmanejoexcepcionesp1vivo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlogGetDto {
    private Integer id;
    private String title;
    private String autor;
    private Date publicationDate;
}
