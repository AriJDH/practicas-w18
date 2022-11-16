package com.example.blogyoutube.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EntradaBlogDtoReq {
    private Integer id;
    private String titulo;
    private String autor;
}
