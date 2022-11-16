package com.demolinks.demolinks.controller;


import com.demolinks.demolinks.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinkController {
    @Autowired
    private ILinkService linkService;

    @PostMapping("")
}