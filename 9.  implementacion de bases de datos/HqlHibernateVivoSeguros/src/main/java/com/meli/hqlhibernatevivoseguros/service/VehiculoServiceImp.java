package com.meli.hqlhibernatevivoseguros.service;

import com.meli.hqlhibernatevivoseguros.dto.PatenteListDTO;
import com.meli.hqlhibernatevivoseguros.dto.PatenteMarcaDTO;
import com.meli.hqlhibernatevivoseguros.dto.PatenteMarcaListDTO;
import com.meli.hqlhibernatevivoseguros.repository.IVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        PatenteListDTO patenteListDTO = this.modelMapper.map(vehiculoList, PatenteListDTO.class);
        return patenteListDTO;
    }

    @Override
    public PatenteMarcaListDTO listarPatenteMarcaOrderByAnioFabricacion() {
        Map<String,String> vehiculoMap = iVehiculoRepository.findAllPatentBrandOrderByAnioFabricacion();
        PatenteMarcaListDTO patenteMarcaListDTO = new PatenteMarcaListDTO();
        vehiculoMap.forEach( (x,y) -> patenteMarcaListDTO.getPatenteMarcaDTOList().add(new PatenteMarcaDTO(x,y)) );
        return patenteMarcaListDTO;
    }

    @Override
    public PatenteListDTO listarPatentesVehiculosCuatroRuedasFabricadosAnioActual() {
        List<String> vehiculoList = iVehiculoRepository.findAllPatentFourWheelActualYear();
        PatenteListDTO patenteListDTO = this.modelMapper.map(vehiculoList, PatenteListDTO.class);
        return patenteListDTO;
    }
}
