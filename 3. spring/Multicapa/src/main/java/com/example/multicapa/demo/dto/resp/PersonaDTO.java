package com.example.multicapa.demo.dto.resp;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service
@Getter
public class PersonaDTO {

    private String nombre;
    private String apellido;
    private int edad;
}
