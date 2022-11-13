package com.darke.covid19.repository;

import com.darke.covid19.dto.request.SintomaRequestDto;
import com.darke.covid19.entity.Sintoma;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SintomaRepository implements ISintomaRepository{
    List<Sintoma> listaSintomas = new ArrayList<>();
    int iterador=1;

    @Override
    public void agregarSintoma(SintomaRequestDto sintomaRequestDto) {
        Sintoma sintoma = new Sintoma(iterador++,
                sintomaRequestDto.getNombre(),
                sintomaRequestDto.getNivel_de_gravedad());

        listaSintomas.add(sintoma);
    }

    @Override
    public List<Sintoma> getSintomas() {
        return listaSintomas;
    }
}
