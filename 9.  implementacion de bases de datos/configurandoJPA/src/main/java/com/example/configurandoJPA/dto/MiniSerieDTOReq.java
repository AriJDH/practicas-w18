package com.example.configurandoJPA.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MiniSerieDTOReq {
    private String name;
    private Double rating;
    private int amount_of_awards;
}
