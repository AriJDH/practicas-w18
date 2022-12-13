package com.band.elasticjpa.service;

import com.band.elasticjpa.dto.EmpleadoNameListRequest;
import com.band.elasticjpa.dto.EmpleadoDto;

import java.util.List;

public interface IEmpleadoService {
    List<EmpleadoDto> getAllEmpleados();

    EmpleadoDto addEmpleado(EmpleadoDto empleadoDto);

    List<EmpleadoDto> getAllEmpleadosByNombre(String nombre);

    List<EmpleadoDto> getAllEmpleadosByNombreList(EmpleadoNameListRequest empleadoNameListRequest);

    List<EmpleadoDto> getAllEmpleadosByEdadGreaterThanEqualOrderByEdadDesc(Integer edad);

    List<EmpleadoDto> getAllEmpleadosByProvinciaContains(String provincia);
}
