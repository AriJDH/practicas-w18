package com.bootcamp.joyeria.controller;

import com.bootcamp.joyeria.dto.req.GetReqDto;
import com.bootcamp.joyeria.dto.view.GemSaveView;
import com.bootcamp.joyeria.dto.view.GemView;
import com.bootcamp.joyeria.service.IGemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class GemController {

    private IGemService service;

    public GemController(IGemService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public ResponseEntity<GemSaveView>save(@RequestBody GetReqDto dto){
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GemView>>findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<?>deleteById(@PathVariable Long id){
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/update/{id}")
    public ResponseEntity<GemView>deleteById(@PathVariable Long id,@RequestBody GetReqDto dto){

        return new ResponseEntity<>(service.updateById(id,dto),HttpStatus.OK);
    }

}
