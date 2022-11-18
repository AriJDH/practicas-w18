package com.spring.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LinkDtoRes {
    private String url;
    private Long id;
    private Integer redirectCount;
    private Boolean isValid;
}
