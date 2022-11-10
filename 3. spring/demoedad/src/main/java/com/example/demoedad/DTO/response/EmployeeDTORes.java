package com.example.demoedad.DTO.response;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTORes {
    private String nombre;
    private String apellido;
    private String message;
}