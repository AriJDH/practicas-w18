package com.jcundere.ejerciciopractico09.controller;

import com.jcundere.ejerciciopractico09.dto.request.LinkRequest;
import com.jcundere.ejerciciopractico09.dto.response.LinkMetricsResponse;
import com.jcundere.ejerciciopractico09.dto.response.LinkResponse;
import com.jcundere.ejerciciopractico09.service.ILinkService;
import com.jcundere.ejerciciopractico09.util.LinkMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
public class LinkController {

    private final ILinkService linkService;


    @PostMapping("/link")
    public ResponseEntity<LinkResponse> createLink(@RequestBody LinkRequest request) {

        return new ResponseEntity<>(linkService.createLink(request), HttpStatus.OK);
    }

    @GetMapping("/link/{linkId}")
    public ModelAndView redirect(@PathVariable Integer linkId, @RequestParam(required = false) String password) {

        String url = linkService.getRedirectByLinkId(linkId, password);
        return new ModelAndView("redirect:" + url);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<LinkMetricsResponse> getLinkMetricsById(@PathVariable Integer linkId) {

        LinkMetricsResponse response = LinkMapper.entity2MetricsResponse(linkService.getLinkById(linkId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<Void> invalidateLink(@PathVariable Integer linkId) {

        linkService.invalidateLinkById(linkId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
