package com.example.joyeria.dto.request;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class JoyaDtoReq {
    private Long id;
    private String nombre;
    private String material;
    private String peso;
    private String particularidad;
    private String poseePiedra;
    private String ventaONo;

}
