package com.example.demo.DTO.DTOResponse;

import com.example.demo.entity.Deporte;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeporteDTORes {

    private List<Deporte> deportes;
    private String message;
    private HttpStatus httpStatus;
}
