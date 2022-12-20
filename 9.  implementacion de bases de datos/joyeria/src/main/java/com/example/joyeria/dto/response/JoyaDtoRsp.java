package com.example.joyeria.dto.response;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class JoyaDtoRsp {
    private Long id;
    private String nombre;
    private String material;
    private String peso;
    private String particularidad;
    private String poseePiedra;
    private String ventaONo;
}
