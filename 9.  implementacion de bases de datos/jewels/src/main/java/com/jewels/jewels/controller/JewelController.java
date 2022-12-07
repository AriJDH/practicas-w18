package com.jewels.jewels.controller;

import com.jewels.jewels.dto.Request.RequestJewelDTO;
import com.jewels.jewels.dto.Response.JewelsResponseDTO;
import com.jewels.jewels.dto.Response.ResponseDTO;
import com.jewels.jewels.service.IJewelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewerly")
public class JewelController {

    private IJewelService jewelService;


    public JewelController(IJewelService jewelService) {
        this.jewelService = jewelService;
    }

    @PostMapping("/new")
    public ResponseEntity<ResponseDTO> create(@RequestBody RequestJewelDTO requestJewelDTO) {
        return new ResponseEntity<>(jewelService.create(requestJewelDTO), HttpStatus.CREATED);
    }

    ;

    @GetMapping("")
    public ResponseEntity<JewelsResponseDTO> listJewels() {
        return new ResponseEntity<>(jewelService.getList(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idJewel}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable Integer idJewel) {
        return new ResponseEntity<>(jewelService.delete(idJewel), HttpStatus.OK);
    }

    @PutMapping("/update/{idJewel}")
    public ResponseEntity<ResponseDTO> update(@PathVariable Integer idJewel, @RequestBody RequestJewelDTO requestJewelDTO) {
        return new ResponseEntity<>(jewelService.update(idJewel, requestJewelDTO), HttpStatus.OK);
    }


}
