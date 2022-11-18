package com.linkTracker.controllers;

import java.nio.InvalidMarkException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.linkTracker.services.ILinkService;
import com.linkTracker.services.LinkServiceIMP;
@RestController
@RequestMapping("/link")
public class LinkController {

    private final ILinkService linkService;


    public LinkController(LinkServiceIMP linkService) {
        this.linkService = linkService;
    }

@PostMapping("/link")
public ResponseEntity<LinkDtoResponse> createLink(@RequestBody LinkDtoRequest reqeust, @RequestParam String password) {
    
}
    
    // @GetMapping("/{linkId}")
    // public int getAnalyticsById(@PathVariable linkId){
        // return linkId;
    // }

    // @PostMapping("/link")
    // public ResponseEntity<LinkResponse> createLink(@RequestBody LinkRequest request, @RequestParam String password) {

    //     return new ResponseEntity<>(HttpStatus.OK);
    // }
}
