package com.example.demo.DTO.Response;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaSintomaDTORes {
    private String fullNombre;
    private Integer edad;
    private List<String> sintomas;
    private String message;
    private HttpStatus httpStatus;
}
