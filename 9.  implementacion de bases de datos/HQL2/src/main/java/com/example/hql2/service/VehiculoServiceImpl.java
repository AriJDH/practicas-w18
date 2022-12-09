package com.example.hql2.service;

import com.example.hql2.dto.response.VehiculoResponse;
import com.example.hql2.dto.response.VehiculoTotalDamageResponse;
import com.example.hql2.entity.VehiculoSiniestro;
import com.example.hql2.repository.VehiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehiculoServiceImpl implements IVehiculoService {

    private final VehiculoRepository vehiculoRepository;

    @Override
    public List<VehiculoResponse> getAllPatentes() {

        List<String> patentes = this.vehiculoRepository.consultaPatentes();

        return patentes
                .stream()
                .map(VehiculoResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehiculoResponse> getAllPatenteAndMarcaOrderByAnioDeFabricacion() {

        List<String[]> result = this.vehiculoRepository.consultaMarcaYPatenteOrdenadoPorAnioFabricacion();

        return result
                .stream()
                .map(vehiculo -> new VehiculoResponse(vehiculo[0], vehiculo[1]))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehiculoResponse> getAllPatenteWhereCantRuedasGreater4AndYearsEqualsTo() {

        List<String> patentes = vehiculoRepository.consultarPatenteFabricados(LocalDate.now().getYear());
        return patentes
                .stream()
                .map(VehiculoResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehiculoResponse> getAllPatenteAndMarcaAndModelWherePerdidaEconomicaEqualsTo10000() {
        List<String[]> vehiculos = vehiculoRepository.consultarVehiculosConSiniestroGrave();

        return vehiculos
                .stream()
                .map(vehiculo -> new VehiculoResponse(vehiculo[0], vehiculo[1], vehiculo[2]))
                .collect(Collectors.toList());
    }

    @Override
    public VehiculoTotalDamageResponse getAllPatenteAndMarcaAndModelAndTotalDamageWherePerdidaEconomicaEqualsTo10000() {

        VehiculoTotalDamageResponse vehiculoTotalDamageResponse = new VehiculoTotalDamageResponse();

        List<VehiculoSiniestro> vehiculoSiniestros = vehiculoRepository.consultarVehiculosSiniestros();

        Double totaldamage = vehiculoSiniestros.stream().mapToDouble(VehiculoSiniestro::getPerdido).sum();

        List<VehiculoResponse> vehiculoResponses = vehiculoSiniestros.stream()
                .map(vehiculoSiniestro -> new VehiculoResponse(vehiculoSiniestro.getPatente(),
                        vehiculoSiniestro.getMarca(), vehiculoSiniestro.getModelo()))
                .collect(Collectors.toList());

        vehiculoTotalDamageResponse.setVehiculoResponseList(vehiculoResponses);
        vehiculoTotalDamageResponse.setPerdidaEconomica(totaldamage);

        return vehiculoTotalDamageResponse;
    }

}
