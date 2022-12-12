package com.example.empresadeseguros.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorExceptionDTOResponse {
    private String mensaje;
    private Integer status;
}
