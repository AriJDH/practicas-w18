package com.example.joyeriapg.service;

import com.example.joyeriapg.dto.request.JoyaRequest;
import com.example.joyeriapg.dto.response.JoyaResponse;
import com.example.joyeriapg.entity.JoyaEntity;

import java.util.List;

public interface IJoyaService {
    List<JoyaResponse> getJoyas();
    void saveJoya(JoyaRequest joyaEntity);
    void deleteJoya(Long id);
    JoyaResponse findJoya(Long id);

    void editJoya(Long id, JoyaRequest joyaRequest);
}
