package com.example.demo.DTO.DTOResponse;

import com.example.demo.entity.PersonaDeporte;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SportPersonsDTORes {
    private List<PersonaDeporte> personas;
    private String message;
    private HttpStatus httpStatus;

}
