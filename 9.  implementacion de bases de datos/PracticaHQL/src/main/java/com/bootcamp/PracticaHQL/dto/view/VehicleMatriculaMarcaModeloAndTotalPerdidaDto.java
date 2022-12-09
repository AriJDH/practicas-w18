package com.bootcamp.PracticaHQL.dto.view;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class VehicleMatriculaMarcaModeloAndTotalPerdidaDto {
    private List<VehiclePatenteMarcaModeloDto> patenteMarcaModeloDtos;
    private Double perdidaTotal;
}
