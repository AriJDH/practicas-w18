package com.example.joyeria_lasperlas.controller;

import com.example.joyeria_lasperlas.dto.request.JewelDTORequest;
import com.example.joyeria_lasperlas.dto.response.JewelDTOResponse;
import com.example.joyeria_lasperlas.service.IServiceJewerly;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class JewelController {
    private final IServiceJewerly iServiceJewerly;

    public JewelController(IServiceJewerly iServiceJewerly){
        this.iServiceJewerly = iServiceJewerly;
    }

    @PostMapping("/jewerly/new")
    public ResponseEntity<?> newJewel(@RequestBody JewelDTORequest jewelDTORequest){
        Long id = iServiceJewerly.saveJewel(jewelDTORequest);
        if (id != null) return new ResponseEntity<>("Id: " + id, HttpStatus.CREATED);
        return new ResponseEntity<>("Registro no guardado", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/jewerly")
    public ResponseEntity<List<JewelDTOResponse>> getJewerly(){
        return new ResponseEntity<>(iServiceJewerly.getJewerly(), HttpStatus.OK);
    }

    @GetMapping("/jewerly/delete/{id}")
    public ResponseEntity<?> logicDelete(@PathVariable Long id){
        iServiceJewerly.logicDelete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/jewerly/update/{id}")
    public ResponseEntity<JewelDTOResponse> updateJewel(@RequestBody JewelDTORequest jewelDTORequest, @PathVariable Long id){
        return new ResponseEntity<>(iServiceJewerly.updateJewel(jewelDTORequest, id), HttpStatus.OK);
    }
}
