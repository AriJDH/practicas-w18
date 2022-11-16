package com.example.linktracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Link {

    private Long id;

    private String url;

    private String password;

    private Boolean invalidado;

    private Integer cantidad;
}
