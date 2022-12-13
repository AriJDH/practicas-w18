package com.example.empleados.util;

import com.example.empleados.domain.Empleado;
import com.example.empleados.dto.EmpleadoDto;
import org.modelmapper.ModelMapper;

public class Converter {

    private static ModelMapper mapper = new ModelMapper();


    public static Empleado toEntity(EmpleadoDto empleado){
        return mapper.map(empleado, Empleado.class);
    }

    public static EmpleadoDto toDto(Empleado empleado){
        return mapper.map(empleado, EmpleadoDto.class);
    }
}
