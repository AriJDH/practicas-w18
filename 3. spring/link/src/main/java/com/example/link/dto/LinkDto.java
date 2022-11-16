package com.example.link.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkDto {

    private Long id;
    private String path;
    private String pass;
    private boolean invalidado;
}
