package com.example.demoedad.DTO.resquest;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTOReq {
    private String nombre;
    private String apellido;
    private String message;
}
