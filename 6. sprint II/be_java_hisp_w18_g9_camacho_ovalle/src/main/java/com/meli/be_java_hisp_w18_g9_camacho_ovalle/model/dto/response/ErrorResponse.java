package com.meli.be_java_hisp_w18_g9_camacho_ovalle.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    // ? =============== Attributes =============== ?

    private Integer status;
    private String message;

}
