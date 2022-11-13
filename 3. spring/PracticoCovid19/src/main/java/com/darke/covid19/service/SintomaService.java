package com.darke.covid19.service;

import com.darke.covid19.dto.request.SintomaRequestDto;
import com.darke.covid19.dto.response.SintomaResponseDto;
import com.darke.covid19.entity.Sintoma;
import com.darke.covid19.repository.ISintomaRepository;
import com.darke.covid19.repository.SintomaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SintomaService implements ISintomaService{
    //Dependency Injections
    ISintomaRepository sintomaRepository;

    public SintomaService(SintomaRepository sintomaRepository) {
        this.sintomaRepository = sintomaRepository;
    }

    @Override
    public List<SintomaResponseDto> getSintomas() {
        List<SintomaResponseDto> listaSintomasDto = new ArrayList<>();
        sintomaRepository.getSintomas().forEach(sintoma -> listaSintomasDto.add(
                new SintomaResponseDto(
                        sintoma.getCodigo(),
                        sintoma.getNombre(),
                        sintoma.getNivel_de_gravedad()
                )
        ) );
        return listaSintomasDto;
    }

    @Override
    public String findSintoma(String sintoma) {
        for (Sintoma sint : sintomaRepository.getSintomas()) {
            if(sint.getNombre().equals(sintoma)) return sint.getNivel_de_gravedad();
        }
        return "No se encuentra ese sintoma";
    }

    @Override
    public void creaSintoma(SintomaRequestDto sintomaRequestDto) {
        sintomaRepository.agregarSintoma(sintomaRequestDto);
    }
}
