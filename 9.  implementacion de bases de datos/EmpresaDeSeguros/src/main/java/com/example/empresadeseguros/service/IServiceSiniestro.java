package com.example.empresadeseguros.service;

import com.example.empresadeseguros.dto.request.SiniestroNewDTORequest;
import com.example.empresadeseguros.dto.response.SiniestroDTOResponse;

import java.util.List;

public interface IServiceSiniestro {
    Integer nuevoSiniestro(SiniestroNewDTORequest siniestroDTO);
    SiniestroDTOResponse findById(Integer id);

    List<SiniestroDTOResponse> findAll();

}
