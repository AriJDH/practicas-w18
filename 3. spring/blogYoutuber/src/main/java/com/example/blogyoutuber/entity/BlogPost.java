package com.example.blogyoutuber.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogPost {
    private Long id;
    private String title;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat
    private Date date;
}
