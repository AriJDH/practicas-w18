package com.spring.calorias.controller;

import com.spring.calorias.dto.IngredienteDtoRes;
import com.spring.calorias.dto.PlatoDtoReq;
import com.spring.calorias.dto.PlatoDtoRes;
import com.spring.calorias.service.FoodService;
import com.spring.calorias.service.IFoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {
    private IFoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping("/platos")
    public ResponseEntity<PlatoDtoRes> getPlato(@RequestBody PlatoDtoReq platoDtoReq) {
        PlatoDtoRes res = foodService.getPlato(platoDtoReq.getName(), platoDtoReq.getGrams());
        if(res == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/platosAll")
    public ResponseEntity<List<PlatoDtoRes>> getPlatos(@RequestBody List<PlatoDtoReq> platosDtoReq) {
        List<PlatoDtoRes> res = foodService.getPlatos(platosDtoReq);
        if(res == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/ingredientes")
    public ResponseEntity<List<IngredienteDtoRes>> getComidas() {
        return new ResponseEntity<>(foodService.getComidas(), HttpStatus.OK);
    }

    @GetMapping("/ingredientes/search")
    public ResponseEntity<List<IngredienteDtoRes>> findComidas(@RequestParam String name) {
        return new ResponseEntity<>(foodService.findComidas(name), HttpStatus.OK);
    }
}
