package com.example.calorias.services;

import com.example.calorias.DTOs.IngredienteDTO;
import com.example.calorias.DTOs.PlatoDTO;
import com.example.calorias.DTOs.PlatoRequestDTO;
import com.example.calorias.entities.Ingrediente;
import com.example.calorias.entities.Plato;
import com.example.calorias.repositories.IngredienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlatoServiceImpl implements PlatoService{
    @Autowired
    IngredienteRepository ingredienteRepository;
    @Override
    public PlatoDTO getPlatoDTO(PlatoRequestDTO platoRequestDTO) {
        List<Ingrediente> ingredientes = platoRequestDTO.getIngredientes().stream()
                .map(nombreIngrediente->ingredienteRepository.findByName(nombreIngrediente)
                        .orElseThrow(() -> new RuntimeException("No existe el ingrediente enviado")))
                .collect(Collectors.toList());
        Plato plato = new Plato(platoRequestDTO.getNombre(), platoRequestDTO.getGramos());
        ingredientes.stream().forEach(ing->plato.addIngrediente(ing));
        ObjectMapper mapper = new ObjectMapper();

        return new PlatoDTO(plato.getNombre(),plato.getIngredientes().stream()
                .map(i->mapper.convertValue(i, IngredienteDTO.class)).collect(Collectors.toList())
                , plato.cantidadCalorias(),
                mapper.convertValue(plato.ingredienteMasCalorico(), IngredienteDTO.class));
    }

    @Override
    public List<PlatoDTO> getPlatosDTOsFromList(List<PlatoRequestDTO> platoRequestDTOS) {
        return platoRequestDTOS.stream().map(plato->getPlatoDTO(plato)).collect(Collectors.toList());
    }
}
