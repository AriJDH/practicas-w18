package com.example.joyeria.controller;

import com.example.joyeria.dto.request.JoyaRequest;
import com.example.joyeria.dto.response.JoyaResponse;
import com.example.joyeria.service.IJoyaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class JoyaController {

    private final IJoyaService joyaService;

    @PostMapping("/jewerly/new")
    public ResponseEntity<JoyaResponse> newJoya(@RequestBody JoyaRequest request) {

        return new ResponseEntity<>(joyaService.createJoya(request), HttpStatus.OK);
    }

    @GetMapping("/jewerly")
    public ResponseEntity<List<JoyaResponse>> getAllJoya() {

        return new ResponseEntity<>(joyaService.findAllJoya(), HttpStatus.OK);
    }

    @PatchMapping("/jewerly/update/{id_modificar}")
    public ResponseEntity<JoyaResponse> updateJoya(@PathVariable Long id_modificar, @RequestBody JoyaRequest request) {

        return new ResponseEntity<>(joyaService.updateJoya(id_modificar, request), HttpStatus.OK);
    }

    @DeleteMapping("/jewerly/delete/{id}")
    public ResponseEntity<Void> deleteJoya(@PathVariable Long id) {

        joyaService.deleteJoya(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
