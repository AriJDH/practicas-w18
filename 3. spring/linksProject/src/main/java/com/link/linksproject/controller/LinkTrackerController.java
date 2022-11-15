package com.link.linksproject.controller;

import com.link.linksproject.dto.CreationDTO;
import com.link.linksproject.dto.LinkDTO;
import com.link.linksproject.dto.LinkDTOreq;
import com.link.linksproject.service.ILinkService;
import com.link.linksproject.service.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class LinkTrackerController {

    private ILinkService linkService;

    public LinkTrackerController(LinkService service){
        this.linkService = service;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<CreationDTO> createLink(@RequestBody LinkDTOreq newLink){
        CreationDTO response = new CreationDTO(linkService.createLink(newLink));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/link/{linkId}")
    public void redirectById(@PathVariable int linkId, @RequestParam String password, HttpServletResponse response ) throws IOException {
        String link = linkService.redirectById(linkId, password);
        if(link != null) {
            response.sendRedirect(link);
        }else{
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}

