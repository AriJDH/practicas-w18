package com.blog.blog_youtube.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EntradaBlogOutDTO {

    private String message;

    private int status;

    private Long idBlog;
}
