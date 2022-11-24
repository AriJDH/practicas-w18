package com.jcundere.ejerciciopractico07.controller;

import com.jcundere.ejerciciopractico07.dto.request.FoodMealRequest;
import com.jcundere.ejerciciopractico07.dto.response.FoodMealResponse;
import com.jcundere.ejerciciopractico07.service.IFoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class IndexController {

    private final IFoodService foodService;

    @PostMapping("/getFoodMealInfo")
    public ResponseEntity<FoodMealResponse> getFoodMealInfo(@RequestBody FoodMealRequest foodMealRequest) {

        FoodMealResponse foodMealResponse = foodService.calculateCaloriesTotal(foodMealRequest.getFoodNameList());
        return new ResponseEntity<>(foodMealResponse, HttpStatus.OK);

    }

    @PostMapping("/getFoodMealListInfo")
    public ResponseEntity<List<FoodMealResponse>> getFoodMealListInfo(@RequestBody List<FoodMealRequest> foodMealListRequest) {

        List<FoodMealResponse> foodMealListResponse = foodMealListRequest
                .stream()
                .map(foodMealRequest -> foodService.calculateCaloriesTotal(foodMealRequest.getFoodNameList()))
                .collect(Collectors.toList());

        return new ResponseEntity<>(foodMealListResponse, HttpStatus.OK);

    }

}
