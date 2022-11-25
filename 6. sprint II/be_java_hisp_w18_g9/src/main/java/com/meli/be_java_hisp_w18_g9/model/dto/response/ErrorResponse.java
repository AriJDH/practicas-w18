package com.meli.be_java_hisp_w18_g9.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    // ? =============== Attributes =============== ?

    private Integer status;
    private String message;

}
