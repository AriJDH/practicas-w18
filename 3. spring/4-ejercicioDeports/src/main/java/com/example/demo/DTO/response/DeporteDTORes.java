package com.example.demo.DTO.response;

import lombok.*;
import org.springframework.boot.context.properties.ConstructorBinding;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class DeporteDTORes {
    private String name;
    private String level;
}
