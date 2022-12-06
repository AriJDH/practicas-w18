package com.example.joyeria.service;

import com.example.joyeria.dto.request.JoyaCompletaDTOReq;
import com.example.joyeria.dto.request.JoyaDTOReq;
import com.example.joyeria.dto.response.JoyaDTORes;
import com.example.joyeria.model.Joya;
import com.example.joyeria.repository.IJoyaRepository;
import com.example.joyeria.util.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaServiceImp implements IJoyaService {

    private final IJoyaRepository joyaRepository;


    public JoyaServiceImp(IJoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
    }

    @Override
    public Long create(JoyaDTOReq joya) {
        if (joya.getVentaONo()) {
            Joya joya1 = Mapper.createObjectMapper().convertValue(joya, Joya.class);
            joyaRepository.save(joya1);
            return joya1.getId();
        } else {
            return null;
        }


    }

    @Override
    public List<JoyaDTORes> findAll() {
        List<Joya> joyas = joyaRepository.findAll().stream().filter(joya -> joya.getVentaONo()).collect(Collectors.toList());
        return joyas.stream().map(joya -> Mapper.createObjectMapper().convertValue(joya, JoyaDTORes.class)).collect(Collectors.toList());
    }

    @Override
    public JoyaDTORes findById(Long id) {
        return Mapper.createObjectMapper().convertValue(joyaRepository.findById(id), JoyaDTORes.class);
    }

    @Override
    public void deleteJoya(Long id) {
        Joya joya = joyaRepository.findById(id).orElseThrow(() -> new RuntimeException("Joya no encontrada"));
        joya.setVentaONo(false);
        joyaRepository.save(joya);
    }

    @Override
    public void update(JoyaCompletaDTOReq joya) {
        joyaRepository.save(Mapper.createObjectMapper().convertValue(joya, Joya.class));
    }
}
