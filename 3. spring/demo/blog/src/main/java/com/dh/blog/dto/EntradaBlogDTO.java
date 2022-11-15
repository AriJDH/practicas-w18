package com.dh.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EntradaBlogDTO {

    private int id;
    private String title;
    private String authorName;
    private String dateOfPublication;

}
