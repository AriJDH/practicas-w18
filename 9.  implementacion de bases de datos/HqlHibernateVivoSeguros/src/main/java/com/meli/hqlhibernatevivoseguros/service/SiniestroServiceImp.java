package com.meli.hqlhibernatevivoseguros.service;

import com.meli.hqlhibernatevivoseguros.dto.MatriculaMarcaModeloDTO;
import com.meli.hqlhibernatevivoseguros.dto.MatriculaMarcaModeloListDTO;
import com.meli.hqlhibernatevivoseguros.dto.MatriculaMarcaModeloPerdidaDTO;
import com.meli.hqlhibernatevivoseguros.dto.MatriculaMarcaModeloPerdidaListDTO;
import com.meli.hqlhibernatevivoseguros.dto.VehiculoPerdidaDTO;
import com.meli.hqlhibernatevivoseguros.repository.ISiniestroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SiniestroServiceImp implements ISiniestroService {

    @Autowired
    ISiniestroRepository iSiniestroRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public MatriculaMarcaModeloListDTO listarSiniestroMayorDeMilPesos() {
        List<VehiculoPerdidaDTO> vehiculoList = iSiniestroRepository.findLossGreaterThanTenThousand();
        List<MatriculaMarcaModeloDTO> list = vehiculoList.stream().map(v -> new MatriculaMarcaModeloDTO(v.getVehiculo().getMatricula(), v.getVehiculo().getMarca(), v.getVehiculo().getModelo())).collect(Collectors.toList());
        MatriculaMarcaModeloListDTO matriculaMarcaModeloListDTO = new MatriculaMarcaModeloListDTO();
        matriculaMarcaModeloListDTO.setMatriculaMarcaModeloDTOList(list);
        return matriculaMarcaModeloListDTO;
    }

    @Override
    public MatriculaMarcaModeloPerdidaListDTO listarSiniestroMayorDeMilPesosConPerdida() {
        List<VehiculoPerdidaDTO> vehiculoList = iSiniestroRepository.findLossGreaterThanTenThousand();
        List<MatriculaMarcaModeloPerdidaDTO> list = vehiculoList.stream().map(v -> new MatriculaMarcaModeloPerdidaDTO(v.getVehiculo().getMatricula(), v.getVehiculo().getMarca(), v.getVehiculo().getModelo(),v.getPerdidaEconomica())).collect(Collectors.toList());
        MatriculaMarcaModeloPerdidaListDTO matriculaMarcaModeloPerdidaListDTO = new MatriculaMarcaModeloPerdidaListDTO();
        matriculaMarcaModeloPerdidaListDTO.setMatriculaMarcaModeloPerdidaDTOList(list);
        return matriculaMarcaModeloPerdidaListDTO;
    }
}
