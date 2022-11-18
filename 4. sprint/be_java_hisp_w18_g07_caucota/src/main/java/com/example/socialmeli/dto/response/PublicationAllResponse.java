package com.example.socialmeli.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PublicationAllResponse {
    private String nombre;
    private Integer categoria;
    private Double precio;
}
