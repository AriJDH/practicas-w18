package com.meli.recapitulandospringp2vivo.service;

import com.meli.recapitulandospringp2vivo.dto.request.CreateLinkDTO;
import com.meli.recapitulandospringp2vivo.dto.response.IdLinkDTO;
import com.meli.recapitulandospringp2vivo.dto.response.InvalidateLinkDTO;
import com.meli.recapitulandospringp2vivo.dto.response.MetricDTO;

public interface ILinkService {
    IdLinkDTO create(CreateLinkDTO createLinkDTO);
    String redirect(Integer id,String password);
    MetricDTO getMetrics(Integer id);
    InvalidateLinkDTO invalidateLink(Integer id);
}
