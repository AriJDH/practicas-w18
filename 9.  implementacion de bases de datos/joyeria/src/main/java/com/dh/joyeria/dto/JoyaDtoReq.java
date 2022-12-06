package com.dh.joyeria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class JoyaDtoReq {

    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private boolean posee_piedra;
    private boolean ventaONo;

}

// JSON REPRESENTATION
// {
//  "nombre": "",
//  "material": "",
//  "peso": 0.0,
//  "particularidad": "",
//  "posee_piedra": false,
//  "ventaONo": false
//}