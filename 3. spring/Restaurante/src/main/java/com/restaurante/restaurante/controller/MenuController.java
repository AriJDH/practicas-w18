package com.restaurante.restaurante.controller;

import com.restaurante.restaurante.dto.MenuDto;
import com.restaurante.restaurante.dto.PlatoDto;
import com.restaurante.restaurante.service.ImenuService;
import com.restaurante.restaurante.service.MenuServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class MenuController {

    ImenuService menuService = new MenuServiceImp();

    @PostMapping(path ="/plato")
    public ResponseEntity<MenuDto> getTotalCalorias(@RequestBody PlatoDto plato){
        MenuDto rtaDto = new MenuDto();
        rtaDto.setCargaCalorica(menuService.getTotalCalorias(plato));
        rtaDto.setIngredientes(menuService.getAllIngredientes(plato));
        rtaDto.setIngredienteMaxCalorias(menuService.getMayorCaloria(plato));
        return new ResponseEntity<>(rtaDto,HttpStatus.OK);
    }
}
