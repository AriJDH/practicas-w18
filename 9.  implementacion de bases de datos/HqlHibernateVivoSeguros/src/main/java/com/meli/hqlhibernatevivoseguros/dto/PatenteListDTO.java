package com.meli.hqlhibernatevivoseguros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PatenteListDTO {
    private List<String> patenteList;
}
