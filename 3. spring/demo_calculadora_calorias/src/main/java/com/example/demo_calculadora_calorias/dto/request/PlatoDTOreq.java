package com.example.demo_calculadora_calorias.dto.request;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class  PlatoDTOreq {
    private List<String> platos;
}
