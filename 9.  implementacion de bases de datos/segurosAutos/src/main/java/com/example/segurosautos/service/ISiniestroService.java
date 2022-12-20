package com.example.segurosautos.service;

import com.example.segurosautos.dto.SiniestroDto;
import com.example.segurosautos.entity.model.PatenteModeloMarca;

import java.util.List;

public interface ISiniestroService {

    public void addSiniestro(SiniestroDto siniestro);
    public List<PatenteModeloMarca> listarVehiculosPorPerdidaEconomicaSiniestro();
    public List<PatenteModeloMarca> listarVehiculosPorPerdidaEconomicaSiniestroYMontoTotal();
}
