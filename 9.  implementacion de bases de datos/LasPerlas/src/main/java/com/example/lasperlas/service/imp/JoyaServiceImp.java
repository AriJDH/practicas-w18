package com.example.lasperlas.service.imp;

import com.example.lasperlas.dto.GenericResponseDto;
import com.example.lasperlas.dto.JoyasDto;
import com.example.lasperlas.entities.Joyas;
import com.example.lasperlas.exception.NotFoundException;
import com.example.lasperlas.repository.IJoyaRepository;
import com.example.lasperlas.service.IJoyaService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaServiceImp implements IJoyaService {

    private final IJoyaRepository joyaRepository;
    private final ObjectMapper mapper;

    public JoyaServiceImp(IJoyaRepository joyaRepository, ObjectMapper mapper) {
        this.joyaRepository = joyaRepository;
        this.mapper = mapper;
    }

    @Override
    public JoyasDto findById(Long id) {
        return mapper.convertValue(joyaRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Jewels with id " + id + " not found.")), JoyasDto.class);
    }

    @Override
    public List<JoyasDto> findAll() {
        return mapper.convertValue(joyaRepository.findAll(), new TypeReference<List<JoyasDto>>() {});
    }

    @Override
    public GenericResponseDto create(JoyasDto joya) {
        joyaRepository.save(mapper.convertValue(joya, Joyas.class));
        return new GenericResponseDto("Jewels created with id: " + joya.getId(),201);
    }

    @Override
    public GenericResponseDto delete(Long id) {
        findById(id);
        joyaRepository.deleteById(id);
        return new GenericResponseDto("Jewels with id: " + id + " was delete.",204);
    }

    @Override
    public GenericResponseDto update(Long id, JoyasDto joya) {
        JoyasDto joyaDto = findById(id);

        joyaDto.setNombre(joya.getNombre());
        joyaDto.setPeso(joya.getPeso());
        joyaDto.setMaterial(joya.getMaterial());
        joyaDto.setParticularidad(joya.getParticularidad());
        joyaDto.setPoseePiedra(joya.getPoseePiedra());
        joyaDto.setVentaONo(joya.getPoseePiedra());

        joyaRepository.save(mapper.convertValue(joyaDto, Joyas.class));

        return new GenericResponseDto("Jewels updated with id: " + joyaDto.getId(),201);
    }
}
