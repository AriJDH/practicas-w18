package com.jpa.joyeria.service;

import com.jpa.joyeria.dto.GenericResponseDTO;
import com.jpa.joyeria.exception.GenericException;
import com.jpa.joyeria.model.Joya;
import com.jpa.joyeria.repository.IJoyaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaService implements IJoyaService {

    IJoyaRepository joyaRepository;

    public JoyaService(IJoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
    }

    @Override
    public GenericResponseDTO save(Joya joyaDTOreq) {
        joyaRepository.save(joyaDTOreq);
        return new GenericResponseDTO("Joya creada con nro ID "+ joyaDTOreq.getNro_identificatorio());
    }

    @Override
    public List<Joya> getAll() {
        return joyaRepository.findAll()
                .stream()
                .filter(j -> j.getVentaONo() == true).collect(Collectors.toList());
    }

    @Override
    public GenericResponseDTO update(Joya joya, int id) {
        joyaRepository.findById(id).orElseThrow(()-> new GenericException("Joya no encontrada"));
        Joya updatedJoya = joyaRepository.save(joya);
        return new GenericResponseDTO("Joya "+updatedJoya.getNro_identificatorio()+" modificada correctamente");
    }

    @Override
    public GenericResponseDTO delete(int id) {
        Joya storedJoya = joyaRepository.findById(id).orElseThrow(()-> new GenericException("Joya no encontrada"));
        joyaRepository.delete(storedJoya);
        return new GenericResponseDTO("Joya con numero identificatorio "+id+" eliminada correctamente");
    }
}
