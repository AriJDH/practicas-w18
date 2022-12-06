package com.example.joyeriapg.service;

import com.example.joyeriapg.dto.request.JoyaRequest;
import com.example.joyeriapg.dto.response.JoyaResponse;
import com.example.joyeriapg.entity.JoyaEntity;
import com.example.joyeriapg.repository.IJoyaRepository;
import com.example.joyeriapg.util.JoyaMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JoyaService implements IJoyaService{
    private final IJoyaRepository joyaRepository;

    public JoyaService(IJoyaRepository joyaRepository){
        this.joyaRepository = joyaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<JoyaResponse> getJoyas() {
        List<JoyaEntity> joyasList = this.joyaRepository.findAll();
        List<JoyaResponse> joyaResponseList = JoyaMapper.joyaList2JoyaResponseList(joyasList);
        return joyaResponseList;
    }

    @Override
    @Transactional
    public void saveJoya(JoyaRequest joyaRequest) {
        if(joyaRequest.getVentaONo()){
            this.joyaRepository.save(JoyaMapper.joyaRequest2JoyaEntity(joyaRequest));
        }else{

        }
    }

    @Override
    @Transactional
    public void deleteJoya(Long id) {
        if(!findJoya(id).getVentaONo()){
            this.joyaRepository.deleteById(id);
        }else {

        }
    }

    @Override
    @Transactional(readOnly = true)
    public JoyaResponse findJoya(Long id) {
        JoyaEntity joyaEntity = this.joyaRepository.findById(id).orElse(null);
        return JoyaMapper.joya2JoyaResponse(joyaEntity);
    }

    @Override
    public void editJoya(Long id, JoyaRequest joyaRequest) {
        JoyaEntity joyaOriginal = findJoya(id);
    }
}
