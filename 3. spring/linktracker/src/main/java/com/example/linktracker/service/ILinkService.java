package com.example.linktracker.service;

import com.link.dto.LinkRequestDTO;
import com.link.dto.LinkResponseEstadisticaDTO;
import com.link.dto.LinkResponseIdDTO;

public interface ILinkService {

    public LinkResponseIdDTO addLink(LinkRequestDTO linkRequestDTO);
    public LinkResponseEstadisticaDTO obtenerEstadisticas(Long id);
    public LinkResponseIdDTO invalidarLink(Long id);
    public LinkResponseIdDTO redireccionarLink(Long id, String password);
}
