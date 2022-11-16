package com.example.link.controller;

import com.example.link.dto.LinkDto;
import com.example.link.dto.LinkIdDto;
import com.example.link.service.LinkService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class LinkController {

    private final LinkService linkService;


    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/link")
    public ResponseEntity<LinkIdDto> crear(@RequestBody LinkDto linkDto){

        return new ResponseEntity<>(linkService.crear(linkDto), HttpStatus.OK);
    }

    @GetMapping("/link/{id}")
    public ResponseEntity<Object> redirigir(@PathVariable Long id) throws URISyntaxException {
        String dire = linkService.path(id);
        if(dire != null){
            return new ResponseEntity<>("redirect:/" + dire, HttpStatus.PERMANENT_REDIRECT);
        }else{
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        }

        /*if(dire != null) {
            URI externalUri = new URI("https://some-domain.com/path/to/somewhere");
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setLocation(externalUri);

            return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
        }else{
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        }*/
    }

}
