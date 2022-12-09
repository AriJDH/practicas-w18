package com.example.joyerialasperlas.controller;

import com.example.joyerialasperlas.dto.request.CreateJewelRequestDto;
import com.example.joyerialasperlas.dto.response.JewelResponseDto;
import com.example.joyerialasperlas.dto.response.JewelDto;
import com.example.joyerialasperlas.service.IJewelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewelry")
public class JewelController {

    @Autowired
    IJewelService jewelService;

    @PostMapping("/new")
    public ResponseEntity<JewelResponseDto> createJewel(@RequestBody CreateJewelRequestDto newJewel){
        return new ResponseEntity<>(jewelService.createJewel(newJewel),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<JewelDto>> getJewels(){
        return new ResponseEntity<>(jewelService.getJewels(),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<JewelResponseDto> deleteJewel(@PathVariable Long id){
    return new ResponseEntity<>(jewelService.deleteJewel(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CreateJewelRequestDto> updateJewel(@PathVariable Long id, @RequestBody CreateJewelRequestDto updateJewel){
        return new ResponseEntity<>(jewelService.updateJewel(id,updateJewel),HttpStatus.OK);
    }

}
