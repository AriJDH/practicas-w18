package com.iseeyou.linktracker.controller;

import com.iseeyou.linktracker.dto.request.LinkDTOReq;
import com.iseeyou.linktracker.dto.response.LinkDTORes;
import com.iseeyou.linktracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkController {

    @Autowired
    private ILinkService linkService;

    @PostMapping("/link")
    public ResponseEntity<LinkDTORes> createLink(
            @RequestParam("password") String password,
            @RequestBody LinkDTOReq linkDTOReq) {
        return new ResponseEntity<>(linkService.createLink(linkDTOReq, password),
                HttpStatus.CREATED);
    }
}
