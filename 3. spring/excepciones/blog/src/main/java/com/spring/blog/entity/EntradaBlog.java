package com.spring.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntradaBlog {
    private Integer id;
    private String title;
    private String author;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public EntradaBlog(Integer id, EntradaBlog entradaBlog) {
        this.id = id;
        this.title = entradaBlog.getTitle();
        this.author = entradaBlog.getAuthor();
        this.date = entradaBlog.getDate();
    }
}
