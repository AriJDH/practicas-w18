package com.mercadolibre.Redirect.service;

import com.mercadolibre.Redirect.dto.request.LinkRequestDTO;
import com.mercadolibre.Redirect.dto.response.LinkResponseCounterDTO;
import com.mercadolibre.Redirect.dto.response.LinkResponseIdDTO;

public interface ILinkService {
    LinkResponseIdDTO addLink(LinkRequestDTO linkRequestDTO);
    LinkResponseCounterDTO getLinkCounter(Integer id);
    LinkResponseIdDTO invalidateLink(Integer id);
    LinkResponseIdDTO redirectLink(Integer id, String password);
}
