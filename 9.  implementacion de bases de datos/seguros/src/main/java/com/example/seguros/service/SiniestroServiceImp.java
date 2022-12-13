package com.example.seguros.service;

import com.example.seguros.dto.request.SiniestroDTOReq;
import com.example.seguros.dto.response.SiniestroDTORes;
import com.example.seguros.model.Siniestro;
import com.example.seguros.respository.ISiniestroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class SiniestroServiceImp implements ISiniestroService{
    ISiniestroRepository siniestroRepository;

    private ModelMapper mapper;

    public SiniestroServiceImp(ISiniestroRepository siniestroRepository) {
        this.siniestroRepository = siniestroRepository;
    }

    @Override
    public SiniestroDTORes createSiniestro(SiniestroDTOReq siniestroDTOReq) {
        Siniestro siniestro = getMapper().map(siniestroDTOReq,Siniestro.class);
        return getMapper().map(siniestroRepository.save(siniestro),SiniestroDTORes.class);
    }

    private ModelMapper getMapper() {
        if (mapper == null)
            return mapper = new ModelMapper();

        return mapper;
    }
}
