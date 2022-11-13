package com.darke.covid19.service;

import com.darke.covid19.dto.request.SintomaRequestDto;
import com.darke.covid19.dto.response.SintomaResponseDto;
import com.darke.covid19.entity.Sintoma;

import java.util.List;
import java.util.Optional;

public interface ISintomaService {
    List<SintomaResponseDto> getSintomas();
    String findSintoma(String sintoma);
    void creaSintoma(SintomaRequestDto sintomaRequestDto);
}
