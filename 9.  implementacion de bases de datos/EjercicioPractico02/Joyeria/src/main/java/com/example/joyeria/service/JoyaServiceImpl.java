package com.example.joyeria.service;

import com.example.joyeria.dto.request.JoyaRequest;
import com.example.joyeria.dto.response.JoyaResponse;
import com.example.joyeria.entity.JoyaEntity;
import com.example.joyeria.repository.JoyaRepository;
import com.example.joyeria.util.mapper.JoyaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JoyaServiceImpl implements IJoyaService {

    private final JoyaRepository joyaRepository;


    @Override
    public JoyaResponse createJoya(JoyaRequest joya) {

        JoyaResponse result = JoyaMapper.entity2Response(joyaRepository.save(JoyaMapper.request2Entity(joya)));
        return result;
    }

    @Override
    public List<JoyaResponse> findAllJoya() {

        List<JoyaEntity> entityList = joyaRepository.findAll();
        entityList = entityList.stream().filter(JoyaEntity::getVentaONo).collect(Collectors.toList());

        return JoyaMapper.entityList2ResponseList(entityList);
    }

    @Override
    public JoyaResponse updateJoya(Long id, JoyaRequest joya) {

        if (!joyaRepository.existsById(id)) {
            throw new RuntimeException("Joya no encontrada !");
        }

        JoyaEntity entity = JoyaMapper.request2Entity(joya);
        entity.setNroIdentidicatorio(id);
        joyaRepository.save(entity);
        return JoyaMapper.entity2Response(entity);

    }

    @Override
    public void deleteJoya(Long id) {

        if (!joyaRepository.existsById(id)) {
            throw new RuntimeException("Joya no encontrada !");
        }

        JoyaEntity entity = joyaRepository.findById(id).get();
        entity.setVentaONo(false);
        joyaRepository.save(entity);

    }

}
