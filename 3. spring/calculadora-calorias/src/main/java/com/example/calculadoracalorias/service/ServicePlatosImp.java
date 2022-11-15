package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.dto.request.PlatoRequestDTO;
import com.example.calculadoracalorias.dto.response.PlatoResponseAddOkDTO;
import com.example.calculadoracalorias.dto.response.PlatoResponseDTO;
import com.example.calculadoracalorias.entity.Plato;
import com.example.calculadoracalorias.exception.ConflictResourceException;
import com.example.calculadoracalorias.exception.NotFoundException;
import com.example.calculadoracalorias.repository.IRepositoryPlatos;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicePlatosImp implements IServicePlatos{

    private IRepositoryPlatos repositoryPlatos;
    private ObjectMapper mapper = new ObjectMapper();

    public ServicePlatosImp(IRepositoryPlatos repositoryPlatos) {
        this.repositoryPlatos = repositoryPlatos;
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public PlatoResponseAddOkDTO add(PlatoRequestDTO plato) {
        Plato platoEncontrado = repositoryPlatos.findByName(plato.getName());
        if (platoEncontrado != null){
            throw new ConflictResourceException("El plato " + plato.getName() + " ya se encuentra registrado en el menú.");
        }
        return new PlatoResponseAddOkDTO(plato.getName(), "Plato agregado con éxito!");
    }

    @Override
    public List<PlatoResponseDTO> listAll() {
        return repositoryPlatos.listAll().stream().map(x->mapper.convertValue(x, PlatoResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public PlatoResponseDTO findByName(String name) {
        Plato platoEncontrado = repositoryPlatos.findByName(name);
        if (platoEncontrado == null){
            throw new NotFoundException("El plato " + name + " no se encuentra registrado en el menú.");
        }
        return mapper.convertValue(platoEncontrado, PlatoResponseDTO.class);
    }
}
