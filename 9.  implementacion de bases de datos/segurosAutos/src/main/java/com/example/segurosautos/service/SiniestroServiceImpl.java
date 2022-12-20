package com.example.segurosautos.service;

import com.example.segurosautos.dto.SiniestroDto;
import com.example.segurosautos.entity.Siniestro;
import com.example.segurosautos.entity.Vehiculo;
import com.example.segurosautos.entity.model.PatenteModeloMarca;
import com.example.segurosautos.repository.ISiniestroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class SiniestroServiceImpl implements ISiniestroService{

    private final ISiniestroRepository siniestroRepository;
    private final VehiculoServiceImpl vehiculoService;
    private ModelMapper maper = new ModelMapper();
    DateTimeFormatter df = DateTimeFormatter .ofPattern("dd-MM-yyyy");

    public SiniestroServiceImpl(ISiniestroRepository siniestroRepository, VehiculoServiceImpl vehiculoService) {
        this.siniestroRepository = siniestroRepository;
        this.vehiculoService = vehiculoService;
    }

    @Override
    public void addSiniestro(SiniestroDto siniestro) {
        Siniestro siniestroEntity = new Siniestro();
        siniestroEntity.setFechaSiniestro(LocalDate.parse(siniestro.getFechaSiniestro(), df));
        siniestroEntity.setPerdidaEconomica(siniestro.getPerdidaEconomica());
        Vehiculo vehiculoEntity = maper.map(vehiculoService.getVehiculo(siniestro.getVehiculoId()), Vehiculo.class);
        vehiculoEntity.setId(siniestro.getVehiculoId());
        siniestroEntity.setVehiculoDenunciado(vehiculoEntity);
        siniestroRepository.save(siniestroEntity);
    }

    @Override
    public List<PatenteModeloMarca> listarVehiculosPorPerdidaEconomicaSiniestro() {
        Double monto = 10_000D;
        return siniestroRepository.listarVehiculosPorPerdidaEconomicaSiniestro(monto);
    }

    @Override
    public List<PatenteModeloMarca> listarVehiculosPorPerdidaEconomicaSiniestroYMontoTotal() {
        Double monto = 10_000D;
        return siniestroRepository.listarVehiculosPorPerdidaEconomicaSiniestroYMontoTotal(monto);
    }


}
