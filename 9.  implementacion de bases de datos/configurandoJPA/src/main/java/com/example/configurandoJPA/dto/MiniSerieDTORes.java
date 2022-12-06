package com.example.configurandoJPA.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter @Setter
public class MiniSerieDTORes {
    private Long id;
    private String name;
    private Double rating;
    private int amount_of_awards;
}
