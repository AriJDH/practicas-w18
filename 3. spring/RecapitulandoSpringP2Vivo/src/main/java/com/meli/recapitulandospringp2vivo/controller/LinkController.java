package com.meli.recapitulandospringp2vivo.controller;

import com.meli.recapitulandospringp2vivo.dto.request.CreateLinkDTO;
import com.meli.recapitulandospringp2vivo.dto.response.IdLinkDTO;
import com.meli.recapitulandospringp2vivo.dto.response.InvalidateLinkDTO;
import com.meli.recapitulandospringp2vivo.dto.response.MetricDTO;
import com.meli.recapitulandospringp2vivo.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class LinkController {

    @Autowired
    ILinkService iLinkService;

    @PostMapping("/link")
    public ResponseEntity<IdLinkDTO> createLink(@RequestBody CreateLinkDTO createLinkDTO) {
        return new ResponseEntity<>(iLinkService.create(createLinkDTO), HttpStatus.OK);
    }

    @GetMapping("/link/{id}")
    public void redirectLink(@PathVariable Integer id,@RequestParam String password,HttpServletResponse response) throws IOException {
        var link = iLinkService.redirect(id,password);
        response.sendRedirect(link);
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<MetricDTO> getMetrics(@PathVariable Integer id) {
        return new ResponseEntity<>(iLinkService.getMetrics(id),HttpStatus.OK);
    }

    @DeleteMapping("/invalidate/{id}")
    public ResponseEntity<InvalidateLinkDTO> invalidateLink (@PathVariable Integer id) {
        return new ResponseEntity<>(iLinkService.invalidateLink(id),HttpStatus.OK);
    }
}
