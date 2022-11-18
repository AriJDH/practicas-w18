package com.spring.linktracker.controller;

import com.spring.linktracker.dto.LinkDtoReq;
import com.spring.linktracker.dto.LinkDtoRes;
import com.spring.linktracker.entity.Link;
import com.spring.linktracker.exception.BadNameLink;
import com.spring.linktracker.service.ILinkService;
import com.spring.linktracker.service.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkController {

    ILinkService linkService;

    public LinkController(LinkService linkService){
        this.linkService = linkService;
    }

    @PostMapping("/link")
    public ResponseEntity<LinkDtoRes> createLink(@RequestBody LinkDtoReq request) {
        //linkService.createLink(request);
        String message = "URL invalido...";
        if(!request.getUrl().contains("www.")){
            throw new BadNameLink(message);
        }
        return new ResponseEntity<>(linkService.createLink(request),HttpStatus.OK);
    }


    @GetMapping("/link/{linkId}")
    public ResponseEntity<LinkDtoRes> redirectLink(@PathVariable Long linkId) {
        String message = "URL invalido...";
        if(!linkService.searchLink(linkId).getUrl().contains("www.")){
            throw new BadNameLink(message);
        }
        return new ResponseEntity<>(linkService.redirectLink(linkId),HttpStatus.OK);

    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<Integer> getStadistics(@PathVariable Long linkId){
       System.out.println("Cantidad de veces que se redirecciono: " + linkService.getAnaliticsById(linkId) );
        return new ResponseEntity<>(linkService.getAnaliticsById(linkId), HttpStatus.OK);

    }


    }



