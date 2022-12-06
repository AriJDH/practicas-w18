package com.example.joyeriapg.controller;

import com.example.joyeriapg.dto.request.JoyaRequest;
import com.example.joyeriapg.dto.response.JoyaResponse;
import com.example.joyeriapg.service.IJoyaService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class JoyaController {
    @Autowired
    IJoyaService joyaService;

    @PostMapping("/jewelry/new")
    public ResponseEntity<String> createJoya(@RequestBody JoyaRequest joyaRequest){
        this.joyaService.saveJoya(joyaRequest);
        return new ResponseEntity<>("La joya fue creada correctamente", HttpStatus.CREATED);
    }



    @GetMapping("/jewelry")
    public ResponseEntity<List<JoyaResponse>> getJoyas(){
        List<JoyaResponse> joyaResponseList = this.joyaService.getJoyas();
        return new ResponseEntity<>(joyaResponseList, HttpStatus.OK);
    }


    @PostMapping("jewelry/delete/{id}")
    public ResponseEntity<String> deleteJoya(@PathVariable Long id){
        this.joyaService.deleteJoya(id);
        return new ResponseEntity<>("Joya elimada correctamente", HttpStatus.ACCEPTED);
    }

    @PostMapping("jewelry/update/{id}")
    public ResponseEntity<JoyaResponse> actualizar(@PathVariable Long id, @RequestBody JoyaRequest joyaRequest){
        this.joyaService.editJoya(id, joyaRequest);
        JoyaResponse joyaResponse = this.joyaService.findJoya(id);
        return new ResponseEntity<>(joyaResponse, HttpStatus.ACCEPTED);
    }

}
