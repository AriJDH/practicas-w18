package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.dto.response.PlatoResponseDto;
import com.example.calculadoracalorias.entity.Ingrediente;
import com.example.calculadoracalorias.entity.Plato;
import com.example.calculadoracalorias.repository.IIngredienteRepository;
import com.example.calculadoracalorias.repository.IPlatoRepository;
import com.example.calculadoracalorias.repository.IngredienteRepository;
import com.example.calculadoracalorias.repository.PlatoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlatoService implements IPlatoService{
    IPlatoRepository platoRepository;
    IIngredienteRepository ingredienteRepository;

    public PlatoService(PlatoRepository platoRepository, IngredienteRepository ingredienteRepository) {
        this.platoRepository = platoRepository;
        this.ingredienteRepository = ingredienteRepository;
    }

    @Override
    public PlatoResponseDto platoCalorias(String menu, float peso) {
        float totalCalorias=0.0f;
        Integer mayorCaloria=0;
        String ingredienteMayorCaloria;
        int indice=0;
        PlatoResponseDto platoDto = new PlatoResponseDto();
        platoRepository.generarMenu();
        for (Plato plato : platoRepository.mostrarPlatos()) {
            if(plato.getNombre().equals(menu)){

                for (Ingrediente ingrediente : plato.getIngredientesList() ) {
                    totalCalorias += ingrediente.getCalorias()*(peso/100);
                }

                for(int i=0; i<plato.getIngredientesList().size(); i++){
                    if(mayorCaloria < plato.getIngredientesList().get(i).getCalorias()){
                        mayorCaloria = plato.getIngredientesList().get(i).getCalorias();
                        indice = i;
                    }
                }
                ingredienteMayorCaloria = plato.getIngredientesList().get(indice).getNombre();
                platoDto.setNombre(menu);
                platoDto.setPeso(peso);
                platoDto.setIngredientesList(plato.getIngredientesList());
                platoDto.setTotalCalorias(totalCalorias);
                platoDto.setIngredienteMayoCaloria(ingredienteMayorCaloria);
                break;
            }
        }
        return platoDto;
    }

    @Override
    public List<PlatoResponseDto> listaPlatoCalorias(float peso) {
        List<PlatoResponseDto> listaPlatoDto = new ArrayList<>();

        float totalCalorias=0.0f;
        Integer mayorCaloria=0;
        String ingredienteMayorCaloria;
        int indice=0;
        PlatoResponseDto platoDto;
        platoRepository.generarMenu();
        for (Plato plato : platoRepository.mostrarPlatos()) {
            for (Ingrediente ingrediente : plato.getIngredientesList() ) {
                    totalCalorias += ingrediente.getCalorias()*(peso/100);
                }
            for(int i=0; i<plato.getIngredientesList().size(); i++){
                if(mayorCaloria < plato.getIngredientesList().get(i).getCalorias()){
                    mayorCaloria = plato.getIngredientesList().get(i).getCalorias();
                    indice = i;
                    }
                }
            ingredienteMayorCaloria = plato.getIngredientesList().get(indice).getNombre();
            platoDto = new PlatoResponseDto();
            platoDto.setNombre(plato.getNombre());
            platoDto.setPeso(peso);
            platoDto.setIngredientesList(plato.getIngredientesList());
            platoDto.setTotalCalorias(totalCalorias);
            platoDto.setIngredienteMayoCaloria(ingredienteMayorCaloria);
            listaPlatoDto.add(platoDto);

            totalCalorias=0;
        }
        return listaPlatoDto;
    }
}
