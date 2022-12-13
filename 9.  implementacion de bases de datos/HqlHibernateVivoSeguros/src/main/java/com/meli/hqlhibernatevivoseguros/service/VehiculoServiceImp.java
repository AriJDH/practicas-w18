package com.meli.hqlhibernatevivoseguros.service;

import com.meli.hqlhibernatevivoseguros.dto.PatenteListDTO;
import com.meli.hqlhibernatevivoseguros.dto.PatenteMarcaDTO;
import com.meli.hqlhibernatevivoseguros.dto.PatenteMarcaListDTO;
import com.meli.hqlhibernatevivoseguros.repository.IVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class VehiculoServiceImp implements IVehiculoService {

    @Autowired
    IVehiculoRepository iVehiculoRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public PatenteListDTO listarPatentes() {
        List<String> vehiculoList = iVehiculoRepository.findAllPatent();
        PatenteListDTO patenteListDTO = new PatenteListDTO(vehiculoList);
        return patenteListDTO;
    }

    @Override
    public PatenteMarcaListDTO listarPatenteMarcaOrderByAnioFabricacion() {
        List<PatenteMarcaDTO> patenteMarcaDTOList = iVehiculoRepository.findAllPatentBrandOrderByAnioFabricacion();
        PatenteMarcaListDTO patenteMarcaListDTO = new PatenteMarcaListDTO(patenteMarcaDTOList);
        return patenteMarcaListDTO;
    }

    @Override
    public PatenteListDTO listarPatentesVehiculosCuatroRuedasFabricadosAnioActual() {
        List<String> patenteMarcaDTOList = iVehiculoRepository.findAllPatentFourWheelActualYear();
        PatenteListDTO patenteListDTO = new PatenteListDTO(patenteMarcaDTOList);
        return patenteListDTO;
    }
}
