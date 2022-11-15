package com.example.linktracker.controller;

import com.example.linktracker.entity.Link;
import com.example.linktracker.service.ILinkService;
import com.example.linktracker.service.LinkServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LinkController {

    private ILinkService linkService;

    public LinkController(LinkServiceImp linkServiceImp){
        this.linkService = linkServiceImp;
    }

    @PostMapping(path = "/create/{url}")
    public ResponseEntity<Long> createLink(@PathVariable String url){
    return new ResponseEntity<>(linkService.createLink(url), HttpStatus.CREATED);
    }
    @GetMapping(path = "/link/{linkId}")
    public ResponseEntity<RedirectView> redirect(@PathVariable Long linkId){
        return new ResponseEntity<>(linkService.redirect(linkId), HttpStatus.FOUND);
    }
    @GetMapping(path = "/metrics/{linkId}")
    public ResponseEntity<Integer> getMetrics(@PathVariable Long linkId){
        return new ResponseEntity<>(linkService.getMetrics(linkId), HttpStatus.OK);
    }

    @PostMapping(path = "/invalidate/{linkId}")
    public ResponseEntity<String> invalidateLink(@PathVariable Long linkId){
        linkService.deleteLink(linkId);
        return new ResponseEntity<>("Link eliminado", HttpStatus.OK);
    }

    @GetMapping(path = "/getlink/{linkId}")
    public ResponseEntity<Link> findById(@PathVariable Long linkId){
        Link link = linkService.findById(linkId);
        return new ResponseEntity<>(link, HttpStatus.OK);
    }
}
