package com.uhu.multicapa.controller;

import com.uhu.multicapa.dto.request.PersonDTO;
import com.uhu.multicapa.service.IPersonService;
import com.uhu.multicapa.service.PersonServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    private IPersonService personService = new PersonServiceImp();

    @GetMapping("")
    public ResponseEntity<List<PersonDTO>> showList() {
        return new ResponseEntity<>(personService.getPeople(), HttpStatus.OK);
    }
}
