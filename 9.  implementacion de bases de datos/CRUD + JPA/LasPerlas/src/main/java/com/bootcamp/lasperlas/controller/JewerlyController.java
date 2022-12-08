package com.bootcamp.lasperlas.controller;

import java.util.List;

import com.bootcamp.lasperlas.dto.request.JewerlyDtoRequest;
import com.bootcamp.lasperlas.dto.response.JewerlyDtoResponse;
import com.bootcamp.lasperlas.dto.response.JewerlyDtoStatusMessage;
import com.bootcamp.lasperlas.service.IJewerlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jewerly")
public class JewerlyController {
    @Autowired
    private IJewerlyService iJewerlyService;
    @PostMapping("/new")
    public ResponseEntity<JewerlyDtoStatusMessage> create (@RequestBody JewerlyDtoRequest jewerly) {
        JewerlyDtoStatusMessage createdJewerly = iJewerlyService.createJoya(jewerly);
        return ResponseEntity.status(createdJewerly.getStatus()).body(createdJewerly);
    }

    @GetMapping()
    public  ResponseEntity<List<JewerlyDtoResponse>> getAll (){
        List<JewerlyDtoResponse> jewerly = iJewerlyService.findAllJoya();
        return ResponseEntity.status(HttpStatus.OK).body(jewerly);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<JewerlyDtoStatusMessage> delete(@PathVariable Long id){
        JewerlyDtoStatusMessage jewerlyDelete = iJewerlyService.deleteJoya(id);
        return ResponseEntity.status(jewerlyDelete.getStatus()).body(jewerlyDelete);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<JewerlyDtoStatusMessage> update (@PathVariable Long id, @RequestBody JewerlyDtoRequest jewerlyDtoRequest){
        JewerlyDtoStatusMessage updateJewerly = iJewerlyService.updateJoya(id, jewerlyDtoRequest);
        return ResponseEntity.status(updateJewerly.getStatus()).body(updateJewerly);
    }

}
