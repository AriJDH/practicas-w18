package com.dh.linktracker.controller;

import com.dh.linktracker.dto.LinkDTO;
import com.dh.linktracker.dto.LinkDTOres;
import com.dh.linktracker.service.ILinkService;
import com.dh.linktracker.service.LinkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/link")
public class LinkController {

    private final ILinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping
    public ResponseEntity<?> addLink(@RequestBody LinkDTO linkDTO){
        LinkDTOres res = linkService.addLink(linkDTO);
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/{linkId}")
    public ResponseEntity<?> redirectURL(@PathVariable Integer id){
        return null;
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<?> getMetrics(@PathVariable Integer linkId){
        return null;
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<?> invalidate(@PathVariable Integer linkId){
        return null;
    }


}
