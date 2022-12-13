package com.meli.hqlhibernatevivoseguros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PatenteMarcaListDTO {
    private List<PatenteMarcaDTO> patenteMarcaDTOList;
}
