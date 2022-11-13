package com.bootcamp.calculadoraCalorias.controller;

import com.bootcamp.calculadoraCalorias.dto.res.DishDto;
import com.bootcamp.calculadoraCalorias.dto.req.DishReqDto;
import com.bootcamp.calculadoraCalorias.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DishController {


    @Autowired
    private IDishService dishService;

    @PostMapping("/dish")
    public ResponseEntity<DishDto> getData(@RequestBody DishReqDto dishDto){
        return new ResponseEntity<>(dishService.getData(dishDto), HttpStatus.OK);
    }

}
