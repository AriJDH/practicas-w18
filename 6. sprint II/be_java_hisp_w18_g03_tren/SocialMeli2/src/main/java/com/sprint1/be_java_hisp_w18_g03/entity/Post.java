package com.sprint1.be_java_hisp_w18_g03.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private Integer postId;
    private User user;
    private LocalDate date;
    private Product producto;
}


