package com.example.siniestros.service;

import com.example.siniestros.DTOs.SiniestroDTO;
import com.example.siniestros.entity.Siniestro;

public interface SiniestroDbService {
    SiniestroDTO createSiniestro(SiniestroDTO siniestroDTO);
}
