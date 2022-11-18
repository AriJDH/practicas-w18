package com.example.blogyoutuber.dto.request;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class BlogDTORequest {
    private Long id;
    private String title;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
}
