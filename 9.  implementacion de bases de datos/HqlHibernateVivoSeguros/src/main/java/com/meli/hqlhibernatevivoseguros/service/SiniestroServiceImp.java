package com.meli.hqlhibernatevivoseguros.service;

import com.meli.hqlhibernatevivoseguros.dto.MatriculaMarcaModeloListDTO;
import com.meli.hqlhibernatevivoseguros.dto.MatriculaMarcaModeloPerdidaListDTO;
import com.meli.hqlhibernatevivoseguros.entity.Vehiculo;
import com.meli.hqlhibernatevivoseguros.repository.ISiniestroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiniestroServiceImp implements ISiniestroService {

    @Autowired
    ISiniestroRepository iSiniestroRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public MatriculaMarcaModeloListDTO listarSiniestroMayorDeMilPesos() {
        List<Vehiculo> vehiculoList = iSiniestroRepository.findLossGreaterThanTenThousand();
        MatriculaMarcaModeloListDTO matriculaMarcaModeloListDTO = modelMapper.map(vehiculoList, MatriculaMarcaModeloListDTO.class);
        return matriculaMarcaModeloListDTO;
    }

    @Override
    public MatriculaMarcaModeloPerdidaListDTO listarSiniestroMayorDeMilPesosConPerdida() {
        List<Vehiculo> vehiculoList = iSiniestroRepository.findLossGreaterThanTenThousand();
        MatriculaMarcaModeloPerdidaListDTO matriculaMarcaModeloPerdidaListDTO = modelMapper.map(vehiculoList, MatriculaMarcaModeloPerdidaListDTO.class);
        return matriculaMarcaModeloPerdidaListDTO;
    }
}
