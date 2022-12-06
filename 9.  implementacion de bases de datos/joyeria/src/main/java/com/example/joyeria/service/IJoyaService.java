package com.example.joyeria.service;

import com.example.joyeria.dto.request.JoyaCompletaDTOReq;
import com.example.joyeria.dto.request.JoyaDTOReq;
import com.example.joyeria.dto.response.JoyaDTORes;
import com.example.joyeria.model.Joya;
import com.example.joyeria.repository.IJoyaRepository;

import java.util.List;

public interface IJoyaService {


    Long create(JoyaDTOReq joya);


    List<JoyaDTORes> findAll();

    JoyaDTORes findById(Long id);

    void deleteJoya(Long id);

    void update(JoyaCompletaDTOReq joya);

}
