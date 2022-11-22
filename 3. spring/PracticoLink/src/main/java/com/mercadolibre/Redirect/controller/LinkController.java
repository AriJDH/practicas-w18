package com.mercadolibre.Redirect.controller;

import com.mercadolibre.Redirect.dto.request.LinkRequestDTO;
import com.mercadolibre.Redirect.dto.response.LinkResponseCounterDTO;
import com.mercadolibre.Redirect.dto.response.LinkResponseIdDTO;
import com.mercadolibre.Redirect.service.ILinkService;
import com.mercadolibre.Redirect.service.LinkService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkController {
    private ILinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/createLink")
    public ResponseEntity<LinkResponseIdDTO> createLink(@RequestBody LinkRequestDTO linkRequestDTO){
        return new ResponseEntity<>(linkService.addLink(linkRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/metrics/{linkID}")
    public ResponseEntity<LinkResponseCounterDTO> statics (@PathVariable Integer linkID){
        return new ResponseEntity<>(linkService.getLinkCounter(linkID), HttpStatus.OK);
    }

    @PostMapping("/link/{linkID}")
    public ResponseEntity<LinkResponseIdDTO> redirect(@PathVariable Integer linkID, @RequestParam String password){
        return new ResponseEntity<>(linkService.redirectLink(linkID, password), HttpStatus.MULTIPLE_CHOICES);
    }

    @PostMapping("/invalidate/{LinkID}")
    public ResponseEntity<LinkResponseIdDTO> invalidate(@PathVariable Integer LinkID){
        return new ResponseEntity<>(linkService.invalidateLink(LinkID), HttpStatus.OK);
    }


}
