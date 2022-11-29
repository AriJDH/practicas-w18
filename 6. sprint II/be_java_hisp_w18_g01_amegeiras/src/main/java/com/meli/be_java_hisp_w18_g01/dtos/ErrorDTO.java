package com.meli.be_java_hisp_w18_g01.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ErrorDTO {
    private Integer codigo;
    private String descripcion;
}
