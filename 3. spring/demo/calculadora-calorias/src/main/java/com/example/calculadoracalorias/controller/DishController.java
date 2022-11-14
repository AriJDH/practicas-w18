package com.example.calculadoracalorias.controller;

import com.example.calculadoracalorias.dto.require.DishDTOreq;
import com.example.calculadoracalorias.dto.require.DishToPostDTOreq;
import com.example.calculadoracalorias.dto.response.DishDTOres;
import com.example.calculadoracalorias.service.DishService;
import com.example.calculadoracalorias.service.IDishService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DishController {
    private final IDishService service;

    public DishController(DishService service) {
        this.service = service;
    }

    @GetMapping("/dish")
    public ResponseEntity<?> findDish(@RequestBody DishDTOreq dishDTO){
        DishDTOres dish = service.getDish(dishDTO);
        return new ResponseEntity<DishDTOres>(dish, HttpStatus.OK);
    }

    @GetMapping("/dishes")
    public ResponseEntity<List<DishDTOres>> findDishes(@RequestBody List<DishDTOreq> dishesDTOreq){
        List<DishDTOres> dishes = service.findDishes(dishesDTOreq);
        return new ResponseEntity<List<DishDTOres>>(dishes, HttpStatus.OK);
    }

    @PostMapping("/addDish")
    public ResponseEntity<?> addDish(@RequestBody DishToPostDTOreq dishToAdd){
        service.addDish(dishToAdd);
        return ResponseEntity.ok().body("Plato agregado correctamente.");
    }

}
