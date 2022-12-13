package com.example.empresa_elasticsearch.service;

import com.example.empresa_elasticsearch.dto.CreacionEmpleadoDTO;
import com.example.empresa_elasticsearch.dto.ModificacionEmpleadoDTO;

public interface IEmpleadoService {

    String crearEmpleado(CreacionEmpleadoDTO creacionEmpleadoDTO);

    String modificarEmpleado(ModificacionEmpleadoDTO modificacionEmpleadoDTO);
}
