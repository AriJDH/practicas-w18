package com.example.spring.excepciones.tracker.controller;

import com.example.spring.excepciones.tracker.dto.request.LinkDTOReq;
import com.example.spring.excepciones.tracker.dto.response.LinkDTORes;
import com.example.spring.excepciones.tracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("/tracker")
public class LinkController {

    @Autowired
    private ILinkService linkService;

    @PostMapping("/create")
    public ResponseEntity<LinkDTORes> createLink(@RequestBody LinkDTOReq linkDTOReq) {
        return new ResponseEntity<>(linkService.createLink(linkDTOReq), HttpStatus.CREATED);
    }

    //http://localhost:8080/link/{linkId}

    @GetMapping("/link/{linkId}")
    public ResponseEntity<Void> redirect(@PathVariable int id) {
        //  HttpHeaders httpHeaders = new HttpHeaders();


        return null;
    }


}
