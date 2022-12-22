package com.example.joyeria.service;

import com.example.joyeria.dto.request.JoyaRequest;
import com.example.joyeria.dto.response.JoyaResponse;
import com.example.joyeria.entity.JoyaEntity;

import java.util.List;

public interface IJoyaService {

    JoyaResponse createJoya(JoyaRequest joya);

    List<JoyaResponse> findAllJoya();

    JoyaResponse updateJoya(Long id, JoyaRequest joya);

    void deleteJoya(Long id);

}
