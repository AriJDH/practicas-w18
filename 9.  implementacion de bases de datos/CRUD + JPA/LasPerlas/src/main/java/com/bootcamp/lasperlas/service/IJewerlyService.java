package com.bootcamp.lasperlas.service;

import java.util.List;

import com.bootcamp.lasperlas.dto.request.JewerlyDtoRequest;
import com.bootcamp.lasperlas.dto.response.JewerlyDtoResponse;
import com.bootcamp.lasperlas.dto.response.JewerlyDtoStatusMessage;

public interface IJewerlyService {
    JewerlyDtoStatusMessage createJoya (JewerlyDtoRequest jewerlyDtoRequest);
    List<JewerlyDtoResponse> findAllJoya();
    JewerlyDtoStatusMessage deleteJoya (Long id);
    JewerlyDtoStatusMessage updateJoya (Long id, JewerlyDtoRequest jewerlyDtoRequest);
}
