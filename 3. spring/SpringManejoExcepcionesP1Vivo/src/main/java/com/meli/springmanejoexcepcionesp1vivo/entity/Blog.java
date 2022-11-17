package com.meli.springmanejoexcepcionesp1vivo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    private Integer id;
    private String title;
    private String autor;
    private Date publicationDate;

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", autor='" + autor + '\'' +
                ", publicationDate=" + publicationDate +
                '}';
    }
}
