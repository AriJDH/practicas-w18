package com.example.demo.DTO.Response;

import com.example.demo.entity.Sintoma;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SintomaDTORes {
    private List<Sintoma> sintomaList;
    private String message;
    private HttpStatus httpStatus;
}
