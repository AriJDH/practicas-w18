package com.example.demo_calculadora_calorias.service;

import com.example.demo_calculadora_calorias.dto.request.PlatoDTOreq;
import com.example.demo_calculadora_calorias.dto.response.EstructuraPlatoDtores;
import com.example.demo_calculadora_calorias.dto.response.PlatoDTOres;
import com.example.demo_calculadora_calorias.entity.Plato;
import com.example.demo_calculadora_calorias.repositoty.IPlatoRepository;
import com.example.demo_calculadora_calorias.repositoty.PlatoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlatoService implements IPlatoService{

    IPlatoRepository platoRepository = new PlatoRepository();

    @Override
    public List<PlatoDTOres> getPlatos(List<PlatoDTOreq> request) {
        List<Plato> platoList = platoRepository.findAll(); // Cargo la data del repositorio
        List<PlatoDTOres> platoDTOresList = new ArrayList<>();

        if (request != null &&
                request.size() > 0 &&
                platoList != null &&
                platoList.size()>0) {

            for (PlatoDTOreq platoRequest: request) {

                List<EstructuraPlatoDtores> estructuraPlatoDtoresList = new ArrayList<>();

                for (String ingrediente: platoRequest.getPlatos()) {
                    try {
                        EstructuraPlatoDtores estructuraPlatoDtores = platoList.stream()
                                .map(m-> new EstructuraPlatoDtores(m.getName(), m.getCalories()))
                                .filter(f->f.getName().equals(ingrediente))
                                .findAny()
                                .get();

                        if (estructuraPlatoDtores != null) {
                            estructuraPlatoDtoresList.add(estructuraPlatoDtores);
                        }
                    } catch (Exception e) {
                        System.out.println("Ingrediente no encontrado "+ ingrediente);
                    }
                }

                PlatoDTOres platoDTOres = new PlatoDTOres(
                        estructuraPlatoDtoresList.stream().mapToInt(m->m.getCalories()).sum(),
                        estructuraPlatoDtoresList,
                        estructuraPlatoDtoresList.stream().max(Comparator.comparing(f->f.getCalories())).get().getName()
                );

                platoDTOresList.add(platoDTOres);
            }
        }

        return platoDTOresList;
    }
}
