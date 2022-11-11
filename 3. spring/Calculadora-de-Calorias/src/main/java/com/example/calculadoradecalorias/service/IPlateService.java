package com.example.calculadoradecalorias.service;

import com.example.calculadoradecalorias.dto.IngredientDto;
import com.example.calculadoradecalorias.dto.request.PlateDTOreq;
import com.example.calculadoradecalorias.dto.response.PlateDTOres;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IPlateService {

    List<PlateDTOres> findAll();

    List<IngredientDto> showIngredients();

    ResponseEntity<PlateDTOres> getPlateData(PlateDTOreq plate);

    ResponseEntity<PlateDTOres> getPlatesData(List<PlateDTOreq> plates);
}
