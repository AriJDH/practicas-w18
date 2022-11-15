package com.link.linksproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkDTO {
    private int id;
    private String link;
    private String password;
    private int cantidadRedirigida;
    private boolean habilitado;
}
