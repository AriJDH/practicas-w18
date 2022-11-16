package com.example.linktracker.controller;


import com.example.linktracker.dto.req.LinkDTOReq;
import com.example.linktracker.dto.resp.LinkCreatedDTOResp;
import com.example.linktracker.dto.resp.LinkDTOResp;
import com.example.linktracker.service.ILinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController

public class LinkController {

    private ILinkService iLinkService;

    public LinkController(ILinkService iLinkService) {
        this.iLinkService = iLinkService;
    }

    @PostMapping
    public ResponseEntity<LinkCreatedDTOResp> createdLink(@RequestBody LinkDTOReq linkDTOReq,
                                                          @RequestParam String password){
        return new ResponseEntity<>(iLinkService.createLink(linkDTOReq, password), HttpStatus.CREATED);
    }

    @GetMapping("/link/{linkid}")
    public void redirect(@PathVariable Integer linkid,
                                                        HttpServletResponse httpServletResponse) throws IOException {
        LinkDTOResp linkDTOResp = iLinkService.redirect(linkid);
        httpServletResponse.sendRedirect(linkDTOResp.getLink());
    }
}

