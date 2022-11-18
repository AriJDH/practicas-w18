package com.spring.linktracker.controller;

import com.spring.linktracker.dto.LinkDtoReq;
import com.spring.linktracker.dto.LinkDtoRes;
import com.spring.linktracker.entity.Link;
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
    public ResponseEntity<LinkDtoRes> createLink(@RequestBody LinkDtoReq request, @RequestParam String password) {


        return new ResponseEntity<>(,HttpStatus.OK);
    }

    @GetMapping("/link/{linkId}")
    public Link createLink(@RequestBody )


}
