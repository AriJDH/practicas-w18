package com.example.seguros.service;

import com.example.seguros.dto.request.SiniestroDTOReq;
import com.example.seguros.dto.response.SiniestroDTORes;

public interface ISiniestroService {
    SiniestroDTORes createSiniestro(SiniestroDTOReq siniestroDTOReq);
}
