package com.mercadolibre.concesionariaautos.service;

import com.mercadolibre.concesionariaautos.dto.AutoRequestDto.AutoRequestDto;
import com.mercadolibre.concesionariaautos.dto.AutoResponseDto.AutoResponseDto;
import com.mercadolibre.concesionariaautos.dto.AutoResponseDto.AutoResponseNoServiceDto;

import java.util.List;

public interface IAutoService {
    AutoRequestDto agregarAuto(AutoRequestDto autoRequestDto);
    List<AutoResponseNoServiceDto> verListadoAutos();
    List<AutoResponseDto> verAutosSegunFecha(String since, String to);
    List<AutoResponseDto> verAutosSegunPrecio(String since, String to);
    AutoResponseDto verAuto(String id);
}
