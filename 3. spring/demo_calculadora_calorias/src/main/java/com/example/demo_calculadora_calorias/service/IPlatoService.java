package com.example.demo_calculadora_calorias.service;

import com.example.demo_calculadora_calorias.dto.request.PlatoDTOreq;
import com.example.demo_calculadora_calorias.dto.response.PlatoDTOres;

import java.util.List;

public interface IPlatoService {
    List<PlatoDTOres> getPlatos(List<PlatoDTOreq> request);
}
