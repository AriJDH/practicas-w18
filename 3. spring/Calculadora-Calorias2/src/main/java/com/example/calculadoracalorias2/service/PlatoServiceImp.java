package com.example.calculadoracalorias2.service;

import com.example.calculadoracalorias2.dto.request.PlatoDto;
import com.example.calculadoracalorias2.entity.Plato;
import com.example.calculadoracalorias2.repository.IPlatoRepository;
import com.example.calculadoracalorias2.repository.PlatoRepositoryImp;
import org.springframework.stereotype.Service;

@Service
public class PlatoServiceImp implements IPlatoService {

    private IPlatoRepository platoRepository = new PlatoRepositoryImp();


    @Override
    public PlatoDto findeOne(String nombre) {
        PlatoDto platoDto = new PlatoDto(platoRepository.calcularTotalCalorias(nombre), platoRepository.listaIngredientes(nombre), platoRepository.maxCalorias(nombre));
        return platoDto;
    }
}
