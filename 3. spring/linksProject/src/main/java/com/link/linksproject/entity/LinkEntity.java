package com.link.linksproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkEntity {

    private int id;
    private String link;
    private String password;
    private int cantidadRedirigida;
    private boolean habilitado;
}
