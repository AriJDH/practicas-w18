package com.example.blog.dtos;

import com.example.blog.entities.Blog;
import com.example.blog.utils.dates.SpanishDateManager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDTO {
    private long id;
    private String titulo;
    private String nombreAutor;
    private String fechaPublicacion;

    public Blog toBlog(){
        return new Blog(this.id, this.titulo, this.nombreAutor, new SpanishDateManager().dateFromString(this.fechaPublicacion));
    }

    public static BlogDTO fromBlog(Blog blog){
        return new BlogDTO(blog.getId(), blog.getTitulo(), blog.getNombreAutor(),
                new SpanishDateManager().dateToString(blog.getFechaPublicacion()));
    }
}
