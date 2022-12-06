package com.example.joyeria.service;

import com.example.joyeria.dto.ConsultaJoyaOutDTO;
import com.example.joyeria.dto.CreacionJoyaDTO;
import com.example.joyeria.dto.ResultadoDTO;
import com.example.joyeria.model.Joya;

public interface IJoyaService {

    ResultadoDTO guardarJoya(CreacionJoyaDTO creacionJoyaDTO);

    ConsultaJoyaOutDTO obtenerJoyas();

    ResultadoDTO eliminarJoya(Long nroIdentificacion);
}
