package com.bootcamp.lasperlas.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.bootcamp.lasperlas.dto.request.JewerlyDtoRequest;
import com.bootcamp.lasperlas.dto.response.JewerlyDtoResponse;
import com.bootcamp.lasperlas.dto.response.JewerlyDtoStatusMessage;
import com.bootcamp.lasperlas.entity.Jewerly;
import com.bootcamp.lasperlas.repository.IJewerlyRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class JewerlyService implements IJewerlyService {
    private final IJewerlyRepository joyaRepository;
    private final ObjectMapper objectMapper;

    @Override
    @Transactional
    public JewerlyDtoStatusMessage createJoya(JewerlyDtoRequest jewerlyDtoRequest) {
        Jewerly jewerlyToSave = objectMapper.convertValue(jewerlyDtoRequest, Jewerly.class);
        jewerlyToSave.setVentaONo(true);
        Jewerly savedJova = joyaRepository.save(jewerlyToSave);
        return new JewerlyDtoStatusMessage(202,"Se creo la joya");
    }

    @Override
    @Transactional(readOnly = true)
    public List<JewerlyDtoResponse> findAllJoya() {
        List<Jewerly> joyitas = joyaRepository.findAll();
        return joyitas.stream().filter(p -> p.getVentaONo())
                .map(p -> new JewerlyDtoResponse(p.getNro_identificatorio(),p.getNombre(),p.getMaterial(),p.getPeso(),p.getParticularidad(),p.getPoseePiedra(),p.getVentaONo())).collect(
                Collectors.toList());
    }

    @Override
    public JewerlyDtoStatusMessage deleteJoya(Long id) {
        if(joyaRepository.existsById(id)){
            Jewerly jewerly = joyaRepository.findById(id).get();
            jewerly.setVentaONo(false);
            joyaRepository.save(jewerly);
            return new JewerlyDtoStatusMessage(200, "Se elimino");
        }else{
            return new JewerlyDtoStatusMessage(500, "Error");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public JewerlyDtoStatusMessage updateJoya(Long id, JewerlyDtoRequest jewerlyDtoRequest) {
       if(joyaRepository.existsById(id)){
           Jewerly jewerly = joyaRepository.findById(id).get();
           jewerly.setNombre(jewerlyDtoRequest.getNombre());
           jewerly.setMaterial(jewerlyDtoRequest.getMaterial());
           jewerly.setPeso(jewerlyDtoRequest.getPeso());
           jewerly.setParticularidad(jewerlyDtoRequest.getParticularidad());
           jewerly.setPoseePiedra(jewerlyDtoRequest.getPoseePiedra());
           jewerly.setVentaONo(true);
           joyaRepository.save(jewerly);
           return new JewerlyDtoStatusMessage(200, "Se actualizo");
       }else{
           return new JewerlyDtoStatusMessage(400,"La joya que desea actualizar no existe");
       }
    }
}
