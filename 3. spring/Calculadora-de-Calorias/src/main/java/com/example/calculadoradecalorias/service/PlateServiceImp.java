package com.example.calculadoradecalorias.service;

import com.example.calculadoradecalorias.dto.IngredientDto;
import com.example.calculadoradecalorias.dto.response.PlateDTOres;
import com.example.calculadoradecalorias.entity.Ingredient;
import com.example.calculadoradecalorias.entity.Plate;
import com.example.calculadoradecalorias.repository.IIngredientRepository;
import com.example.calculadoradecalorias.repository.IPlateRepository;
import com.example.calculadoradecalorias.repository.IngredientRepositoryImp;
import com.example.calculadoradecalorias.repository.PlateRepositoryImp;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlateServiceImp implements IPlateService {

    IIngredientRepository ingredientRepository;
    IPlateRepository iPlateRepository;

    PlateServiceImp(IngredientRepositoryImp ingredientRepository, PlateRepositoryImp iPlateRepository){
        this.ingredientRepository = ingredientRepository;
        this.iPlateRepository = iPlateRepository;
    }

    @Override
    public List<PlateDTOres> findAll(){
        List<Plate> plates = iPlateRepository.findAll();
        List<PlateDTOres> plateDTOres = getPlateDTOResponseMapper(plates);
        return plateDTOres;
    }

    @Override
    public List<IngredientDto> showIngredients(){
        ObjectMapper mapper = new ObjectMapper();
        List<IngredientDto> ingredientDtos = null;
        ingredientDtos = mapper.convertValue(ingredientRepository.findAll(), IngredientDto.class);
        
    }

    private List<PlateDTOres> getPlateDTOResponseMapper(List<Plate> plates){
        ObjectMapper objectMapper = new ObjectMapper();

        //para no tener problemas si en el DTO tengo menos atributos que en la entidad
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return plates.stream()
                .map(p -> objectMapper.convertValue(p, PlateDTOres.class))
                .collect(Collectors.toList());

    }


}
