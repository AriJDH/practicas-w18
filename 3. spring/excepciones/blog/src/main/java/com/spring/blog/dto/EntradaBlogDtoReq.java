package com.spring.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EntradaBlogDtoReq {
    private String title;
    private String author;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
}
