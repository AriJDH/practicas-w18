package com.example.linktracker.controllers;

import com.example.linktracker.dtos.LinkDTO;
import com.example.linktracker.dtos.LinkMetricsDTO;
import com.example.linktracker.dtos.LinkReceptionDTO;
import com.example.linktracker.dtos.ResponseDTO;
import com.example.linktracker.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LinkController {
    @Autowired
    private LinkService linkService;

    @PostMapping("/link")
    public ResponseEntity<LinkDTO> createLink(@RequestBody LinkReceptionDTO linkReceptionDTO){
        return ResponseEntity.ok(linkService.createLink(linkReceptionDTO));
    }

    @GetMapping("/link/{linkId}")
    public RedirectView redirect(@PathVariable long linkId, @RequestParam(required = false) String password){
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(linkService.getRedirectionLink(linkId, password));
        return redirectView;
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<LinkMetricsDTO> getMetric(@PathVariable long linkId){
        return ResponseEntity.ok(linkService.getMetrics(linkId));
    }

    @GetMapping("/invalidate/{linkId}")
    public ResponseEntity<ResponseDTO> invalidateLink(@PathVariable long linkId){
        linkService.invalidateLink(linkId);
        return ResponseEntity.ok(new ResponseDTO("Operación exitosa", 200));
    }
}
