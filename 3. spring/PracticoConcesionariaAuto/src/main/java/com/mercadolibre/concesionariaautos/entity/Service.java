package com.mercadolibre.concesionariaautos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Service {
    private String date;
    private String kilometers;
    private String descriptions;
}
