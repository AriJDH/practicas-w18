package com.darke.covid19.repository;

import com.darke.covid19.dto.request.SintomaRequestDto;
import com.darke.covid19.entity.Sintoma;

import java.util.List;

public interface ISintomaRepository {
    void agregarSintoma(SintomaRequestDto sintomaRequestDto);
    List<Sintoma> getSintomas();
}
