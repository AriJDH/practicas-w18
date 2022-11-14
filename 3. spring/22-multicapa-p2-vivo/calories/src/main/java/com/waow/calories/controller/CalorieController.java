package com.waow.calories.controller;

import com.waow.calories.dto.request.PlateDTOReq;
import com.waow.calories.dto.response.PlateDTORes;
import com.waow.calories.entity.Ingredient;
import com.waow.calories.entity.Plate;
import com.waow.calories.service.ICalorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CalorieController {
    @Autowired
    private ICalorieService calorieService;

    @GetMapping("/{plateName}-{plateGrams}")
    public ResponseEntity<PlateDTORes> showList(@PathVariable String plateName, @PathVariable int plateGrams) {
        return new ResponseEntity<>(calorieService.getPlateInfoByNameGrams(plateName, plateGrams), HttpStatus.OK);
    }

    @PostMapping("/getPlatesInfo")
    public ResponseEntity<List<PlateDTORes>> putPlate(@RequestBody PlateDTOReq plateDTOReq) {
        return new ResponseEntity<>(calorieService.getPlatesInfoByDTO(plateDTOReq), HttpStatus.OK);
    }
}
