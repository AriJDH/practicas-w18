package com.example.testers.controller;

import com.example.testers.service.TestersCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCaseController {

    @Autowired
    private TestersCaseService service;



}
