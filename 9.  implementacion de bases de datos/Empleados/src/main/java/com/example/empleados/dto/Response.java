package com.example.empleados.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Response {
    private EmpleadoDto empleadoDto;
    private String message;
    private Integer statusCode;
}
